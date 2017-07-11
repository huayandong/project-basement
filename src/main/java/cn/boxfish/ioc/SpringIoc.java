package cn.boxfish.ioc;

import cn.boxfish.ioc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huayandong on 17/6/26.
 */
public class SpringIoc {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = (User) context.getBean("user");

        user.add();
    }


}
