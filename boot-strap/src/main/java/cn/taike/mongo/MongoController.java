package cn.taike.mongo;

import cn.taike.mongo.service.CourseLabelService;
import com.google.common.collect.Maps;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

        Map<String, String> msg = Maps.newHashMap();
        try {
            courseLabelService.labelService();

            msg.put("SUCCESS", "YES");
        } catch (Exception e) {
            msg.put("SUCCESS", "NO");
            e.printStackTrace();
        }
        return msg;
    }
}
