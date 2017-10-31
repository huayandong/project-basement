package cn.taike.mongo.paper;

import cn.taike.mongo.paper.PaperInfoEntity;
import cn.taike.mongo.paper.TestListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by huayandong on 17/10/31.
 */
@RestController
public class TestController {

    @Autowired
    private TestListService testListService;

    @RequestMapping(value = "/test/list", method = RequestMethod.GET)
    public void test() {

        List<PaperInfoEntity> list = testListService.getList("123");
        boolean empty = list.isEmpty();
        System.out.println("is empty:" + empty);
    }

}
