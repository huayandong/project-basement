package cn.taike.commons;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by huayadlly on 2017/7/7.
 */
public class StringDemo {

    public static void testStringUtils() {
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isEmpty(""));

        System.out.println(StringUtils.isBlank("  "));
        System.out.println(StringUtils.isEmpty("  "));

    }

    public static void main(String[] args) {
//        testStringUtils();

        testIsAnyBlank();
    }

    /**
     * 可以用来判断多个字符串
     *  isAnyBlank/isNoneBlank 和 isAnyEmpty/isNoneEmpty 判断的参数可以是多个字符串
     *  底层判断依据还是isBlank 和 isEmpty
     */
    public static void testIsAnyBlank() {
        System.out.println("isAnyBlank:" + StringUtils.isAnyBlank("abcggg", " abc "));
        System.out.println("isNoneBlank:" + StringUtils.isNoneBlank("   ", "ccc"));
        System.out.println("-------");
        System.out.println("isAnyEmpty:"+StringUtils.isAnyEmpty("",""));
        System.out.println("isNoneEmpty:" + StringUtils.isNoneEmpty("  ", "fff"));
    }
}
