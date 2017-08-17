package cn.taike.mongo.recognition.service;

import cn.taike.mongo.recognition.app.DataFormatUtils;
import cn.taike.mongo.recognition.domain.PaperRecognitionEntity;
import cn.taike.mongo.recognition.domain.PaperRecognitionRepository;
import cn.taike.mongo.recognition.handler.CompositionEvaluationHandler;
import cn.taike.mongo.recognition.handler.PaperRecognitionHandler;
import cn.taike.mongo.recognition.web.RecognitionController;
import org.joda.time.DateTime;
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
    private CompositionEvaluationHandler compositionEvaluationHandler;

    @Autowired
    private PaperRecognitionRepository paperRecognitionRepository;

    public void submitTaskRecognition(Long userId, String imageUrl) {
        String taskId = UUID.randomUUID().toString();
        paperRecognitionHandler.submit(userId, taskId, imageUrl);
    }

    public void save(RecognitionController.PaperRecognitionRequest request) {
        // 先查询，在保存
        Optional<PaperRecognitionEntity> optEntity = paperRecognitionRepository.findByUserIdAndPaperIdAndPageId(request.getUserId(), request.getPaperId(), request.getPageId());
        if (optEntity.isPresent()) {
            PaperRecognitionEntity entity = optEntity.get();
            entity.setTaskId(request.getTaskId());

            entity.setRecQas(DataFormatUtils.toJsonNoException(request.getQas()));
            entity.setRecImages(DataFormatUtils.toJsonNoException(request.getSub_img_keys()));

            entity.setDevRecognition(request.getWrap_info());
            entity.setDevWords(request.getWords());

            entity.setUpdateTime(DateTime.now());

            paperRecognitionRepository.save(entity);

            // to evaluation
            compositionEvaluationHandler.evaluation(entity.getUserId(), entity.getPaperId(), entity.getPageId(), "text");
        } else {
            PaperRecognitionEntity entity = new PaperRecognitionEntity();

            entity.setUserId(request.getUserId());
            entity.setTaskId(request.getTaskId());
            entity.setPaperId(request.getPaperId());
            entity.setPageId(request.getPageId());

            entity.setDevWords(request.getWords());
            entity.setDevRecognition(request.getWrap_info());

            entity.setRecQas(DataFormatUtils.toJsonNoException(request.getQas()));
            entity.setRecImages(DataFormatUtils.toJsonNoException(request.getSub_img_keys()));

            DateTime dateTime = DateTime.now();
            entity.setCreateTime(dateTime);
            entity.setUpdateTime(dateTime);

            paperRecognitionRepository.save(entity);

            // to evaluation
            compositionEvaluationHandler.evaluation(entity.getUserId(), entity.getPaperId(), entity.getPageId(), "text");

        }


    }
}
