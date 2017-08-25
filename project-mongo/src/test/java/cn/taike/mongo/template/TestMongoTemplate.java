package cn.taike.mongo.template;

import cn.taike.mongo.mongoTemplate.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by huayandong on 17/8/22.
 */

/**
 * yml 配置文件中mongodb的配置: spring.data.mongodb.uri: mongodb://localhost:27017/basement
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMongoTemplate {

    @Autowired
    private StudentService studentService;

    @Test
    public void testMongoAddEntity() {

//        studentService.addStudent();
//
//        studentService.addBookSection();
//
//        studentService.findAll();
//
//        studentService.findByName("002.funny.xlsx");

        studentService.findByPage();
    }

    @Test
    public void testMongoAndMySql() {
        studentService.saveMySqlAndMongo();
    }

    @Test
    public void testMongoQuery() {
        studentService.testMongoTemplate();
    }
}
