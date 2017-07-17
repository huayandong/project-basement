package cn.taike.zop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huayandong on 17/7/17.
 */
public class TestZop {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AopService aopService = (AopService) context.getBean("aopServiceImpl");

        aopService.save();
        System.out.println("----------------------");
        aopService.doAop();
    }
}
