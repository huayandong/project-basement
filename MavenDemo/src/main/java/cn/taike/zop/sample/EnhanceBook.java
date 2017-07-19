package cn.taike.zop.sample;

import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/7/19.
 */
//@Component
public class EnhanceBook {

    public void printLog() {
        System.out.println("print log on Book.....start deleting....");
    }

    public void afterLog() {
        System.out.println("after print log ...deleted done....");
    }
}
