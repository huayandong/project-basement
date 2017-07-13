package cn.taike.inner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huayandong on 17/6/12.
 */
public class Outer {

    //外部类属性
    private String name = "Outer_name_holoo";
    public Integer age = 23;

    //外部类方法
    public void outer_print() {
        System.out.println("外部类在打印：外部");
    }

    /**
     * 成员内部类：可以直接使用外部类的所有成员属性和方法
     * 外部类要访问内部类的所有成员变量和方法时，需要通过内部类的对象来获得
     * 注意：成员内部类中不能含有static的变量和方法--因为成员内部类需要先创建外部类，才能创建他自己
     */
    public class Inner {
        public String Inner_name = "inner_class_name";

        public void inner_print() {
            System.out.println("这是内部类的打印输出：内部" + age);
        }

        //成员内部类使用外部类
        Outer outer = new Outer();

        public void print() {
            outer_print();  //访问方位外部类的方法
            System.out.println("外部类的name:" + name);//访问外部类的属性

            System.out.println("内部类的name:" + Inner_name); //访问内部类的属性
            inner_print();  //访问内部类方法

        }
    }


    public Inner getInner() {
        return new Inner();
    }


    public static void main(String[] args) {

        List<Inner> list = new ArrayList<>();
        Outer outer = new Outer();
        Outer.Inner inner0 = outer.new Inner();
        Inner inner = outer.getInner();
        inner.inner_print();
        inner.print();
        System.out.println("外部类在打印内部类的属性：" + inner.Inner_name);
    }

}
