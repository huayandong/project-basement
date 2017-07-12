package cn.boxfish.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by huayandong on 17/7/12.
 */
public class TestAopMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

        HelloAop helloAopImpl1 = (HelloAop) context.getBean("helloAopImpl1");
        HelloAop helloAopImpl2 = (HelloAop) context.getBean("helloAopImpl2");

        helloAopImpl1.printHello();
        System.out.println("111...");
        helloAopImpl1.doMain();

        System.out.println();
        System.out.println("---------------");
        helloAopImpl2.printHello();
        System.out.println("222...");
        helloAopImpl2.doMain();
    }
}
