package cn.taike.mongo;

import cn.taike.mongo.dao.JdbcTemplateSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayandong on 17/7/31.
 */
@RestController
public class TestController {

    @Autowired
    private JdbcTemplateSample jdbcTemplateSample;

    @RequestMapping(value = "/web/test", method = RequestMethod.GET)
    public Object template() {
//        jdbcTemplateSample.insertSql();

//        jdbcTemplateSample.updateCover();

//        jdbcTemplateSample.deleteBookSection();

        return "OK";
    }
}
