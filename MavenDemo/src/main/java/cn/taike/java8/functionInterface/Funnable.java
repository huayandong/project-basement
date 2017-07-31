package cn.taike.java8.functionInterface;

/**
 * Created by huayandong on 17/7/31.
 */
@FunctionalInterface //非必须注解
public interface Funnable {

    //添加@FunctionalInterface注解后，接口中只能保留一个抽象方法
    void fun();

    default void print() {
        System.out.println("Funable接口中默认的方法...");
    }

    static void grate() {
        System.out.println("Funable接口中静态方法");
    }
}
