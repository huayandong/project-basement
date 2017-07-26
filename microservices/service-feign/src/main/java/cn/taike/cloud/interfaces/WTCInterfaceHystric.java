package cn.taike.cloud.interfaces;

import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/7/24.
 */
@Component
public class WTCInterfaceHystric implements WTCInterface {

    //Feign 中使用断路器，短路的情况下使用该方法
    @Override
    public String sayHelloToMe(String name) {
        return "sorry " + name + ", there are some troubles";
    }
}
