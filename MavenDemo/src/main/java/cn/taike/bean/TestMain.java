package cn.taike.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by huayandong on 17/8/25.
 */
public class TestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configurations.class);

        UseFunctionService bean = context.getBean(UseFunctionService.class);
        String java = bean.testFunction("java");
        System.out.println("this:" + java);

        context.close();
    }
}
