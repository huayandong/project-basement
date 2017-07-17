package cn.taike.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by huayandong on 17/5/23.
 */
public class ColleUtils {

    public static boolean testCollection(List<String> list) {

        if (list != null && list.size() != 0) {
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
//        list.add("aa");
        list.add(null);
        boolean b = testCollection(list);
        System.out.println("为空:" + b);
    }
}
