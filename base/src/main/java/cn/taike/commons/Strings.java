package cn.taike.commons;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by huayandong on 17/7/6.
 */

/**
 * StringUtils.isBlank(CharSequences str) 与 StringUtils.isEmpty(CharSequences str) 比较
 */
public class Strings {


    public static void isEmpty(String a) {

        boolean isEmpty = StringUtils.isEmpty(a);
        System.out.println("is empty : " + isEmpty);
        boolean isBlank = StringUtils.isBlank(a);
        System.out.println("is blank : " + isBlank);
    }

    public static void main(String[] args) {

        System.out.println("is empty : " + StringUtils.isEmpty(" "));   //false
        System.out.println("is blank : " + StringUtils.isBlank(" "));   //true

        System.out.println("------------");

        System.out.println("is empty : " + StringUtils.isEmpty(null));  //true
        System.out.println("is blank : " + StringUtils.isBlank(null));  //true

        System.out.println("------------");

        System.out.println("is empty : " + StringUtils.isEmpty(""));  //true
        System.out.println("is blank : " + StringUtils.isBlank(""));  //true

        System.out.println("------------");

        System.out.println("is empty : " + StringUtils.isEmpty("abc"));  //false
        System.out.println("is blank : " + StringUtils.isBlank("abc"));  //false
    }
}
