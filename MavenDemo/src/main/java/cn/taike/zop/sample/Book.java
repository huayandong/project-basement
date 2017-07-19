package cn.taike.zop.sample;

import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/7/19.
 */
@Component
public class Book {

    public void add() {
        System.out.println("book add.......");
    }

    public void delete() {
        System.out.println("book delete .....");
    }
}
