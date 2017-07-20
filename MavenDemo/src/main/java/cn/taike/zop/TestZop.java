package cn.taike.zop;

import cn.taike.zop.sample.Book;
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
//        aopService.save();
//        System.out.println("----------------------");
//        aopService.doAop();

        Book book = (Book) context.getBean("book");
        book.delete();
//        book.add();

//        System.out.println("2222--------");
        ApplicationContext context2 =
                new ClassPathXmlApplicationContext("aop.xml");
//        Book book = (Book) context2.getBean("book");
//        book.add();
//        book.delete();
    }
}
