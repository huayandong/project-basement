package cn.taike.mongo.paper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huayandong on 17/10/31.
 */
@Service
public class TestListService {

    @Autowired
    private PaperInfoEnRepository paperInfoEnRepository;

    public List<PaperInfoEntity> getList(String paperId) {
        return paperInfoEnRepository.findByPaperId(paperId);
    }

}
