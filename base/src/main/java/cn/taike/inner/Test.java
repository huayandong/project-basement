package cn.taike.inner;

/**
 * Created by huayandong on 17/6/12.
 */
public class Test {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner1 = outer.new Inner();
        Outer.Inner inner = outer.getInner();
    }
}
