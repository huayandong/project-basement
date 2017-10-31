package cn.taike;

/**
 * Created by huayandong on 17/10/19.
 */
public class Advices {

    public void threeMethod() {

        int a = 30;
    }


    public static void main(String[] args) {
        Base base = new Sub();
        base.fun(100, 50);
        System.out.println("---");
        Sub sub = new Sub();
        sub.fun(100, new int[]{50});
    }

    static class Base {
        void fun(int a, int... count) {
            System.out.println("base...fun");
        }
    }

    static class Sub extends Base {
        void fun(int a, int[] count) {
            System.out.println("sub...fun");
        }
    }
}
