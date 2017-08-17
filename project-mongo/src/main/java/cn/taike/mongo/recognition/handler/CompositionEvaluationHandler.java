package cn.taike.mongo.recognition.handler;

import cn.taike.mongo.basement.context.DataFormatUtils;
import cn.taike.mongo.basement.context.BasementProperties;
import cn.taike.mongo.recognition.domain.PaperRecognitionEntity;
import cn.taike.mongo.recognition.domain.PaperRecognitionRepository;
import cn.taike.mongo.recognition.protocol.CompositionResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by huayandong on 17/8/17.
 */
@Slf4j
@Component
public class CompositionEvaluationHandler {

    @Autowired
    private BasementProperties basementProperties;
    @Autowired
    private PaperRecognitionRepository paperRecognitionRepository;

    private static final String SPLIT_REGEX = "<br />\\r\\n";
    private static final String ORIGINAL_ID = "original";
    private static final String REPLACEMENT_ID = "replacement";
    private RestTemplate restTemplate;

    public CompositionEvaluationHandler(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder
                .setConnectTimeout(30_000)
                .setReadTimeout(30_000)
                .build();
    }

    public void evaluation(Long userId, String paperId, String pageId, String text) {
        try {
            // url
            String url = basementProperties.getEvaluationUrl() + "/api/v1";

            // body
            String body = "{\"text\":\" " + text + "\"}";

            // header
            HttpHeaders head = new HttpHeaders();
            head.setContentType(MediaType.APPLICATION_JSON);

            String authString = basementProperties.getEvaluationUserName() + ":" + basementProperties.getEvaluationPassword();
            String authCode = Base64.encodeBase64String(authString.getBytes());
            head.set("Authorization", "Basic " + authCode);

            // request
            HttpEntity<String> request = new HttpEntity<>(body, head);

            // response
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
            log.debug("evaluation, submit evaluation success.");

            if (Objects.equals(response.getStatusCode(), HttpStatus.ACCEPTED)) {

                // send ali ons queue
                String id = response.getHeaders().getLocation().getPath();


            }
        } catch (Exception e) {
            log.error("evaluation composition error.", e);
        }
    }


    public void confirmEvaluation(Long userId, String paperId, String pageId, String confirmId) {
        try {
            // url
            String url = basementProperties.getEvaluationUrl() + confirmId;

            // head
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String authString = basementProperties.getEvaluationUserName() + ":" + basementProperties.getEvaluationPassword();
            String authCode = Base64.encodeBase64String(authString.getBytes());
            headers.set("Authorization", "Basic " + authCode);

            // request
            HttpEntity request = new HttpEntity<>(headers);

            // response
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
            log.debug("evaluation, submit evaluation success.");

            String body = response.getBody();
            CompositionResponse compositionResponse = DataFormatUtils.toEntity(body, CompositionResponse.class);
            CompositionResponse compositions = handHtml(compositionResponse);

            // save
            Optional<PaperRecognitionEntity> optional = paperRecognitionRepository.findByUserIdAndPaperIdAndPageId(userId, paperId, pageId);
            if (optional.isPresent()) {
                PaperRecognitionEntity entity = optional.get();
                entity.setEvaluation(DataFormatUtils.toJsonNoException(compositions));
                entity.setUpdateTime(DateTime.now());

                paperRecognitionRepository.save(entity);
            }
        } catch (Exception e) {
            log.error("confirm evaluation error.");
        }
    }

    public CompositionResponse handHtml(CompositionResponse composition) {
        try {
            List<CompositionResponse.Comments> comments = composition.getComments();
            for (CompositionResponse.Comments comment : comments) {
                String htmlText = comment.getText();
                String[] split = htmlText.split(SPLIT_REGEX);

                String modifyAdvice = split[0];
                String html = split[1];

                Document parse = Jsoup.parse(html);
                String originalText = parse.getElementsByClass(ORIGINAL_ID).first().text();
                String replementText = parse.getElementsByClass(REPLACEMENT_ID).first().text();

                comment.setModifyAdvise(modifyAdvice);
                comment.setOriginalText(originalText);
                comment.setReplacementText(replementText);
            }

            return composition;
        } catch (Exception e) {
            log.error("hand composition html error.", e);
        }
        return composition;
    }
}
