package cn.taike.aops.core;

/**
 * Created by huayandong on 17/7/12.
 */
public class LogHandler {

    public void printLogBeforeMethod() {
        System.out.println("print log before method...");
    }

    public void printLogAfterMethod() {
        System.out.println("print log after method...");
    }
}
