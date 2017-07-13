package cn.taike.strings;

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
        testStringUtils();
    }

}
