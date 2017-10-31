package cn.taike.mongo.list;

import cn.taike.mongo.MongoApplication;
import cn.taike.mongo.paper.PaperInfoEntity;
import cn.taike.mongo.paper.TestListService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by huayandong on 17/10/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MongoApplication.class)
public class TestListEmpty {

    @Autowired
    private TestListService testListService;

    public void testEmpty() {
        List<PaperInfoEntity> list = testListService.getList("123");
        boolean empty = list.isEmpty();
        System.out.println("is empty" + empty);
    }

}
