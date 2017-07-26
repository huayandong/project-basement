package cn.taike.cloud.web;

import cn.taike.cloud.interfaces.WTCInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by huayandong on 17/7/21.
 */
@RestController
public class HelloController {

    @Autowired
    WTCInterface wtcInterface;

    @RequestMapping(value = "/say/hello", method = RequestMethod.GET)
    public String sayHelloToMe(@RequestParam(value = "name") String name) {
        return wtcInterface.sayHelloToMe(name);
    }
}
