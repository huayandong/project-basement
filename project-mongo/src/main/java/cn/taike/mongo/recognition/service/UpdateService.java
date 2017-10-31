package cn.taike.mongo.recognition.service;

import cn.taike.mongo.recognition.domain.PaperInfoEntity;
import cn.taike.mongo.recognition.domain.PaperInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huayandong on 17/10/19.
 */
@Service
public class UpdateService {

    @Autowired
    private PaperInfoRepository paperInfoRepository;

    public void updateArea(String areas) {

        PaperInfoEntity entityByPageId = paperInfoRepository.findByPageId("").get();
        entityByPageId.setAnswerAndAreas(areas);
        entityByPageId.setPaperId("");
        entityByPageId.setBookId("");
        paperInfoRepository.save(entityByPageId);
    }
}
