package cn.taike.zop.sample;

import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/7/19.
 */
//@Component

/**
 * 该类是配置文件方式实现aop操作的增强类，在使用注解方式时弃用；
 */
@Deprecated
public class EnhanceBook {

    public void printLog() {
        System.out.println("print log on Book.....start deleting....");
    }

    public void afterLog() {
        System.out.println("after print log ...deleted done....");
    }
}
