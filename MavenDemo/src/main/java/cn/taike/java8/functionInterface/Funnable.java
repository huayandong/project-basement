package cn.taike.java8.functionInterface;

/**
 * Created by huayandong on 17/7/31.
 */
public interface Funnable {
    void fun();

    default void print() {
        System.out.println("Funable接口中默认的方法...");
    }

    static void grate() {
        System.out.println("Funable接口中静态方法");
    }
}
