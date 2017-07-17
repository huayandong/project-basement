package cn.taike.aops.core;

/**
 * Created by huayandong on 17/7/12.
 */
public class HelloAopImpl2 implements HelloAop {
    @Override
    public void printHello() {
        System.out.println("print Hello from impl2...");
    }

    @Override
    public void doMain() {
        System.out.println("domain this from impl2...");
    }
}
