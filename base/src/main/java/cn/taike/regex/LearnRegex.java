package cn.taike.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by huayandong on 17/6/9.
 */
public class LearnRegex {

    static String regexString = "12345JQK18300602255";
    static String regex1 = "123XXOOabc";

    /**
     * ^ : 为匹配输入字符串的开始位置
     * [0-9]+ : 匹配多个数字
     * [0-9] : 匹配单个数字
     * + : 匹配一个或者多个
     * abc$ : 匹配字母abc并以abc结尾
     * $ : 为匹配输入字符串的结束位置
     */
    public static void testRegex() {
        if (regex1.matches("^[0-9]+abc$")) {
            System.out.println("ok");
        } else {
            System.out.println("NO");
        }

    }

    public static void main(String[] args) {
//        testRegex();

//        Pattern p = Pattern.compile("^[0-9]+.abc$");
        Pattern p = Pattern.compile("2*5?$");
        Matcher m = p.matcher(regex1);
        if (m.matches()) {
            System.out.println("YES   ¦ ");
        } else {
            System.out.println("NO");
        }

    }
}
