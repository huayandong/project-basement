package cn.taike.mongo.recognition.service;

import cn.taike.mongo.recognition.domain.PaperRecognitionEntity;
import cn.taike.mongo.recognition.domain.PaperRecognitionRepository;
import cn.taike.mongo.recognition.handler.PaperRecognitionHandler;
import cn.taike.mongo.recognition.web.RecognitionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by huayandong on 17/8/14.
 */
@Service
public class RecognitionService {

    @Autowired
    private PaperRecognitionHandler paperRecognitionHandler;

    @Autowired
    private PaperRecognitionRepository paperRecognitionRepository;

    public void submitTaskRecognition(Long userId, String imageUrl) {
        String taskId = UUID.randomUUID().toString();
        paperRecognitionHandler.submit(userId, taskId, imageUrl);
    }

    public void save(RecognitionController.PaperRecognitionRequest request) {
        // 先查询，在保存
        Optional<PaperRecognitionEntity> optEntity = paperRecognitionRepository.findByUserIdAndPaperIdAndPageId(request.getUserId(), request.getPaperId(), request.getPageId());
        

    }
}
