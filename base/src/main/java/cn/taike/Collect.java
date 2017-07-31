package cn.taike;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by huayandong on 17/7/29.
 */
public class Collect {

    /**
     * CollectionUtils.isEmpty() 与 MapUtils.isEmpty()对集合是否为空的判断
     * 底层采用的任然是 Collection.isEmpty() 和 Map.isEmpty()对集合的判断
     * 只是在判断之前做了一次封装：判断该集合对象(list/set/map)是否等于“null”
     * 如果等于“null”则直接返回true,避免出现NullPointException;
     * ArrayList<Long> obj = null;
     * obj.isEmpty();   //此时会报异常
     */
    public static void sampleIsEmpty() {
        List<Double> obj = Lists.newArrayList();

//        ArrayList<Long> obj = null;
//        System.out.println("?" + obj.isEmpty());
//        obj.add(null);
        boolean isEmpty = CollectionUtils.isEmpty(obj);
        boolean notEmpty = CollectionUtils.isNotEmpty(obj);
        boolean empty = obj.isEmpty();
        System.out.println("obj.isEmpty:" + empty);
        System.out.println("isEmpty判断list是否为空：" + isEmpty);
        System.out.println("isNotEmpty判断list是否不为空：" + notEmpty);

        boolean flag = obj != null && obj.size() != 0;
        System.out.println("传统的方式：" + flag);

        System.out.println("--------");

        HashMap<Double, Double> map = Maps.newHashMap();
        map.put(null, null);
        boolean mapIsEmpty = MapUtils.isEmpty(map);
        System.out.println("Map的isEmpty判断：" + mapIsEmpty);

       /*
        * StringUtils.equals(null, null)   = true
        * StringUtils.equals(null, "abc")  = false
        * StringUtils.equals("abc", null)  = false
        * StringUtils.equals("abc", "abc") = true
        * StringUtils.equals("abc", "ABC") = false
        */
        boolean equals = StringUtils.equals("abc", "aBc");  //false
        System.out.println("StringUtils: " + equals);
    }


    public static void main(String[] args) {

        sampleIsEmpty();

    }
}
