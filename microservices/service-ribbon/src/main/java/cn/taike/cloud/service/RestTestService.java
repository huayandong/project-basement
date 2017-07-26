package cn.taike.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huayandong on 17/7/21.
 */
@Service
public class RestTestService {

    @Autowired
    private RestTemplate restTemplate;

    public String helloService(String name) {
        return restTemplate.getForObject("http://SERVICE-CLIENT1/say/hello?name=" + name, String.class);
    }
}
