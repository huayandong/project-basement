package cn.taike.aops.core;

/**
 * Created by huayandong on 17/7/12.
 */
public class HelloAopImpl1 implements HelloAop {
    @Override
    public void printHello() {
        System.out.println("print Hello from impl1...");
    }

    @Override
    public void doMain() {
        System.out.println("domain this from impl1...");
    }
}
