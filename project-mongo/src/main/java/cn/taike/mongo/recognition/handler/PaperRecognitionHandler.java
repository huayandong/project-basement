package cn.taike.mongo.recognition.handler;

import cn.taike.mongo.recognition.app.TeProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huayandong on 17/8/14.
 */
@Slf4j
@Component
public class PaperRecognitionHandler {

    @Autowired
    private TeProperties teProperties;

    private RestTemplate restTemplate;

    public PaperRecognitionHandler(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.setConnectTimeout(30_000).setReadTimeout(30_000).build();
    }

    //调用第三方接口
    public void submit(Long userId, String taskId, String imageUrl) {
        try {
            // body
            RequestProtocol requestProtocol = new RequestProtocol(userId, taskId, imageUrl, teProperties.getRecognition());
            ObjectMapper mapper = new ObjectMapper();
            String body = mapper.writeValueAsString(requestProtocol);

            // header
            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.APPLICATION_JSON);

            // request
            HttpEntity<String> request = new HttpEntity<>(body, header);

            // response
            ResponseEntity<String> response = restTemplate.exchange(teProperties.getRecognition(), HttpMethod.POST, request, String.class);
            log.debug("paper, submit task success", response.getBody());
        } catch (Exception e) {
            log.error("Paper, submit task error.", e);
        }
    }


    @Data
    @AllArgsConstructor
    public static class RequestProtocol {
        private Long userId;
        private String taskId;
        private String imageUrl;
        private String callbackUrl;

    }
}
