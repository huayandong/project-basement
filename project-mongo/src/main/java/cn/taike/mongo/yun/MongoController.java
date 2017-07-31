package cn.taike.mongo.yun;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huayandong on 17/7/26.
 */
@RestController
public class MongoController {

    @Resource(name = "courseLabelService")
    private CourseLabelService courseLabelService;

    @RequestMapping(value = "/get/mongo/field", method = RequestMethod.POST)
    public Map<String, String> testMongo() {

        Map<String, String> msg = new HashMap<>();
        try {
//            courseLabelService.labelService();

            courseLabelService.check();

            msg.put("SUCCESS", "YES");
        } catch (Exception e) {
            msg.put("SUCCESS", "NO");
            e.printStackTrace();
        }
        return msg;
    }
}
