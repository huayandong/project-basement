package cn.boxfish.commons;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by huayandong on 17/7/7.
 */
public class Arrays {

    public static void main(String[] args) {

        String[] a = new String[2];
        boolean notEmpty = ArrayUtils.isNotEmpty(a);  //等于 a != null && a.length != 0
        System.out.println("a is not empty？ :" + notEmpty);
        boolean empty = ArrayUtils.isEmpty(a);  //等价于  a == null || a.length == 0
        System.out.println("a is empty? :" + empty);
        System.out.println(java.util.Arrays.toString(a));


        String[] b = new String[]{};
        boolean notEmptyb = ArrayUtils.isNotEmpty(b);
        System.out.println("b is not empty?:" + notEmptyb);
        boolean emptyb = ArrayUtils.isEmpty(b);
        System.out.println("b is empty?:" + emptyb);
        System.out.println(java.util.Arrays.toString(b));


    }
}
