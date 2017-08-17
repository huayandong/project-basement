package cn.taike.mongo.recognition.service;

import cn.taike.mongo.basement.context.DataFormatUtils;
import cn.taike.mongo.recognition.domain.PaperRecognitionEntity;
import cn.taike.mongo.recognition.domain.PaperRecognitionRepository;
import cn.taike.mongo.recognition.handler.CompositionEvaluationHandler;
import cn.taike.mongo.recognition.handler.PaperRecognitionHandler;
import cn.taike.mongo.recognition.protocol.RecognitionDetail;
import cn.taike.mongo.recognition.web.RecognitionController;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    // get list
    public List<RecognitionController.ResponseList> getLists(Long userId) {

        List<RecognitionController.ResponseList> list = Lists.newArrayList();

        List<String> paperIdList = paperRecognitionRepository.selectDistinctPaperId(userId);
        paperIdList.forEach(paperId -> {
            Optional<String> paperNameOptional = paperRecognitionRepository.selectDistinctPaperName(userId, paperId);
            if (paperNameOptional.isPresent()) {
                String paperName = paperNameOptional.get();
                RecognitionController.ResponseList response = new RecognitionController.ResponseList(userId, paperId, paperName);
                list.add(response);
            }
        });

        return list;
    }

    // get detail
    public List<RecognitionDetail> getDetail(Long userId, String paperId) {

        List<RecognitionDetail> resultList = Lists.newArrayList();
        List<PaperRecognitionEntity> entities = paperRecognitionRepository.findByUserIdAndPaperId(userId, paperId);
        for (PaperRecognitionEntity entity : entities) {
            RecognitionDetail detail = new RecognitionDetail();

            detail.setUser_id(userId);
            detail.setPaper_id(paperId);
            detail.setPage_id(entity.getPageId());
            detail.setPaper_name(entity.getPaperName());
            detail.setTask_id(entity.getTaskId());
            detail.setQas(entity.getRecQas());
            detail.setSub_img_key(entity.getRecImages());
            detail.setEvaluation(entity.getEvaluation());

            resultList.add(detail);
        }
        return resultList;
    }
}
