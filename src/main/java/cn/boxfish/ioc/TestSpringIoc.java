package cn.boxfish.ioc;

import cn.boxfish.ioc.act.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huayandong on 17/6/26.
 */
public class TestSpringIoc {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) context.getBean("user");

        userService.add();
    }


}
