package cn.taike.cloud.web;

import cn.taike.cloud.service.RestTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by huayandong on 17/7/21.
 */
@RestController
public class RestTestController {

    @Resource(name = "restTestService")
    private RestTestService restTestService;

    @RequestMapping(value = "/hi")
    public String hello(@RequestParam String name) {
        return restTestService.helloService(name);
    }
}
