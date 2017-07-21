package cn.taike.cloud.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by huayandong on 17/7/21.
 */
@FeignClient(value = "service-client1")  //注解value属性写的是 服务名 。
public interface WTCInterface {

    @RequestMapping(value = "/say/hello", method = RequestMethod.GET)
    String sayHelloToMe(@RequestParam(value = "name") String name);
}
