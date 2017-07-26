package cn.taike.cloud.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayandong on 17/7/24.
 */
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/say/hello")
    public String home(@RequestParam String name) {
        return "Hello, My name is: " + name + ",I am from port: " + port;
    }
}
