package cn.taike.mongo.recognition.web;

import cn.taike.mongo.recognition.service.RecognitionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by huayandong on 17/8/14.
 */
@Slf4j
@RestController
public class RecognitionController {

    @Autowired
    private RecognitionService recognitionService;

    // 接受app上传图片请求
    @RequestMapping(value = "/paper/recognition/submit", method = RequestMethod.POST)
    public Object subImage(@RequestParam(value = "access_token") String token,
                           @RequestBody TaskRequest request) {
        try {
            Long userId = Long.valueOf(token);
            recognitionService.submitTaskRecognition(userId, request.getImageUrl());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("paper, submit recognition image error.", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Data
    public static class TaskRequest {
        private String imageUrl;
    }

    // 回调
    @RequestMapping(value = "/paper/recognition/callback", method = RequestMethod.POST)
    public Object callback(@RequestBody PaperRecognitionRequest request) {
        try {
            recognitionService.save(request);
            return ResponseEntity.ok();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Data
    public static class PaperRecognitionRequest {
        private Long userId;

        private String paperId;
        private String pageId;

        private String taskId;
        private List<QuestionAndAnswer> qas = Lists.newArrayList();
    }

    @Data
    public static class QuestionAndAnswer {
        private Boolean result_right;
        private Double result_accuracy;
        private String result_detail;
    }

}
