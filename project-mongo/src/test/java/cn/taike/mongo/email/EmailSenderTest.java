package cn.taike.mongo.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huayandong on 17/8/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private Sender sender;

    @Test
    public void testSenderEmail(){
        sender.sendMessage();
    }
}
