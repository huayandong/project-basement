package cn.taike.mongo.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huayandong on 17/8/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestEventController {

    @Autowired
    private EventController eventController;

    @Test
    public void testSentEventController() {
        Object o = eventController.eventController();
        System.out.println(o);
    }
}
