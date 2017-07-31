package cn.taike.commons;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by huayandong on 17/7/7.
 */
public class SampleArrays {

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

        testArray();

    }

    public static void testArray() {

        List<String> list = Lists.newArrayList("12", "23", "34");

        //将List集合转换成数组
        Object[] objects = list.toArray();
        System.out.println(ArrayUtils.toString(objects));


        String[] arr = new String[2];
        arr[0] = "张三";
        arr[1] = "司马懿";
        //将数组转换成list集合
        List<String> list1 = java.util.Arrays.asList(arr);

        //将数组转换成set集合
        Set set = new HashSet(list1);
        set.forEach(System.out::println);

    }
}
