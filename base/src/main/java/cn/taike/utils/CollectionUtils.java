package cn.taike.utils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by huayandong on 17/5/22.
 */
public class CollectionUtils {

    //guava Lists.transform：用于转换集合内部元素的类型，之后返回新collection
    public void transFormUtils() {
        List<String> pathList = Lists.newArrayList();
        List<Path> list = Lists.transform(pathList, input -> Paths.get(input));
        HashSet<Path> set = Sets.newHashSet();
        set.addAll(list);
    }

    //函数对象
    public static Function<Double, Double> functionObject() {
        return input -> Math.sqrt(input);
    }

    public static Function<Double, Double> functionObject_bak() {
        return input -> Math.sqrt(input);
    }

    public List<Path> transForm(List<String> list) {

        //将String类型的List集合转换成Path类型的集合
        List<Path> newList = Lists.transform(list, filePath -> Paths.get(filePath));

        //将集合转换成数组
        Path[] pathArray = Lists.transform(list, input -> Paths.get(input)).toArray(new Path[]{});

        List<Path> list2 = Lists.transform(list, new Function<String, Path>() {
            @Override
            public Path apply(String input) {
                return null;
            }
        });

        List<Path> transedList = Lists.transform(list, input -> Paths.get(input));

        return newList;
    }

    public static Map<String, Integer> mapTrandForm(Map<String, String> map) {
        Map<String, Integer> map2 = Maps.transformEntries(map, (key, value) -> Integer.valueOf(value)+100);
        return map2;
    }



    public static void main(String[] args) {
        Map<String, String> map = Maps.newHashMap();
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        Map<String, Integer> stringIntegerMap = mapTrandForm(map);
        System.out.println("transMap:" + stringIntegerMap);
    }


}
