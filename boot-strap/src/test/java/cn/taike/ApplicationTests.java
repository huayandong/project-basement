package cn.taike;

import cn.taike.mongo.service.CourseLabelService;
import cn.taike.run.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private CourseLabelService courseLabelService;

    @Test
    public void contextLoads() {
        try {
            courseLabelService.labelService();
            System.out.println("done");
        } catch (Exception e) {
            System.out.println("no...");
            e.printStackTrace();
        }

    }

}
