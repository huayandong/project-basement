package cn.taike.mongo.recognition.web;

import cn.taike.mongo.recognition.handler.UserTokenHandler;
import cn.taike.mongo.basement.exception.IllegalUserTokenException;
import cn.taike.mongo.recognition.protocol.RecognitionDetail;
import cn.taike.mongo.recognition.service.RecognitionService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by huayandong on 17/8/14.
 */
@Slf4j
@RestController
public class RecognitionController {

    @Autowired
    private RecognitionService recognitionService;

    @Autowired
    private UserTokenHandler userTokenHandler;

    // app submit image
    @RequestMapping(value = "/paper/recognition/submit", method = RequestMethod.POST)
    public Object subImage(@RequestParam(value = "access_token") String token,
                           @RequestBody TaskRequest request) {
        try {
            Long userId = userTokenHandler.exchangeUserId(token);
            recognitionService.submitTaskRecognition(userId, request.getImageUrl());
            return ResponseEntity.ok();

        } catch (IllegalUserTokenException e) {
            log.error("paper submit img, user token error.", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            log.error("paper, submit recognition image error.", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Data
    public static class TaskRequest {
        private String imageUrl;
    }

    // python callback
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

        private String wrap_info;
        private String words;

        private Map<String, String> sub_img_keys = Maps.newHashMap();
        private List<QuestionAndAnswer> qas = Lists.newArrayList();
    }

    @Data
    public static class QuestionAndAnswer {
        private Boolean result_right;
        private Double result_accuracy;
        private String result_detail;

        private String question_id;
        private String predict;
        private String type;
        private List<String> locations = Lists.newArrayList();
    }


    // app get recognition list
    @RequestMapping(value = "/paper/recognition/list", method = RequestMethod.GET)
    public Object queryRecognitionList(@RequestParam(value = "access_token") String token) {
        try {
            Long userId = userTokenHandler.exchangeUserId(token);
            return recognitionService.getLists(userId);

        } catch (IllegalUserTokenException e) {
            log.error("paper, user token error.", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            log.error("paper, get recognition list error.", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @Data
    @NoArgsConstructor
    public static class ResponseList {
        private Long user_id;
        private String paper_id;
        private String paper_name;

        public ResponseList(Long user_id, String paper_id, String paper_name) {
            this.user_id = user_id;
            this.paper_id = paper_id;
            this.paper_name = paper_name;
        }
    }


    // app get recognition detail
    @RequestMapping(value = "/app/recognition/detail", method = RequestMethod.GET)
    public Object queryRecognitionDetail(@RequestParam(value = "access_token") String token,
                                         @RequestBody ResponseList param) {
        try {
            Long userId = userTokenHandler.exchangeUserId(token);
            return recognitionService.getDetail(userId, param.getPaper_id());

        } catch (IllegalUserTokenException e) {
            log.error("paper, user token error.", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            log.error("paper, get recognition detail error.", e);
            return ResponseEntity.badRequest().build();
        }
    }


}
