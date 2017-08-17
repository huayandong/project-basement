package cn.taike.mongo.recognition.handler;

import cn.taike.mongo.basement.context.BasementProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private BasementProperties basementProperties;

    private RestTemplate restTemplate;

    public PaperRecognitionHandler(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.setConnectTimeout(30_000).setReadTimeout(30_000).build();
    }

    //调用第三方接口
    public void submit(Long userId, String taskId, String imageUrl) {
        try {
            log.debug("paper, begin submit task.");

            // body
            RequestProtocol body = new RequestProtocol(userId, taskId, imageUrl, basementProperties.getCallbackUrl());

            // header
            HttpHeaders header = new HttpHeaders();
            header.setContentType(MediaType.APPLICATION_JSON);

            // request
            HttpEntity request = new HttpEntity<>(body, header);

            // response
            ResponseEntity<String> response = restTemplate.exchange(basementProperties.getRecognitionUrl(), HttpMethod.POST, request, String.class);
            log.debug("paper, submit task success", response.getBody());
        } catch (Exception e) {
            log.error("Paper, submit task error.", e);
        }
    }


    @Data
    @NoArgsConstructor
    public static class RequestProtocol {
        private Long userId;
        private String taskId;
        private String imageUrl;
        private String callbackUrl;

        public RequestProtocol(Long userId, String taskId, String imageUrl, String callbackUrl) {
            this.userId = userId;
            this.taskId = taskId;
            this.imageUrl = imageUrl;
            this.callbackUrl = callbackUrl;
        }
    }
}
