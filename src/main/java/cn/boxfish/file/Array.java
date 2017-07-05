package cn.boxfish.file;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by huayandong on 17/7/5.
 */
public class Array {

    public static void main(String[] args) {

        String[] a = new String[2];
        boolean empty = ArrayUtils.isEmpty(a);  //等价于  a == null || a.length == 0
        System.out.println("empty? :" + empty);
        boolean notEmpty = ArrayUtils.isNotEmpty(a);  //等于 a != null && a.length != 0
        System.out.println("Not Empty？ :" + notEmpty);
    }
}
