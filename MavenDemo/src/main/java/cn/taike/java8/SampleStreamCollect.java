package cn.taike.java8;

import cn.taike.entity.Dish;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created by huayandong on 17/7/30.
 */
public class SampleStreamCollect {

    private static List<Dish> list = Lists.newArrayList(
            new Dish(12, "food1", "Vagetable", 500, true),
            new Dish(124, "food12", "beef", 800, false),
            new Dish(125, "food13", "soup", 300, true)
    );

    public static void sampleStream() {

        //统计流中元素个数：
//        list.stream().collect(Collectors.counting());  同下
        long count = list.stream().count();
        System.out.println("count: " + count);

        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> collect = list.stream().collect(maxBy(dishComparator));
        collect.ifPresent(item -> System.out.println("最大值的对象：" + item));

        //两种去流中最大值得方式：
        Optional<Dish> max1 = list.stream().max(Comparator.comparingInt(Dish::getCalories)); //这种方式得到的值最大的对象
        max1.ifPresent(max5 -> System.out.println("max5:" + max5));//max5:Dish{id=124, name='food12', type='beef', calories='800'}
        OptionalInt max = list.stream().mapToInt(Dish::getCalories).max();//这种方式得到你的是值最大的值
        max.ifPresent(max6 -> System.out.println("amx6:" + max6)); //amx6:800

        //求和
        list.stream().collect(summingInt(Dish::getCalories));
        int sum = list.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("总和：" + sum);

        List<Double> l = Lists.newArrayList();
        Double average = list.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        System.out.println("平均数：" + average);
        list.stream().mapToDouble(Dish::getCalories).average() //这种求平均值的方式返货的是容器
                .ifPresent(l::add);
        System.out.println("从容器中取出的平均值:" + l);
        int reduceSum = list.stream().mapToInt(Dish::getCalories).reduce(0, (i, j) -> i + j);
        System.out.println("reduceSum: " + reduceSum);

        //返回所有对数值计算的容器：总和、平均值、总个数、最大/小值，可以使用get的方式取出来
        IntSummaryStatistics intSummaryStatistics = list.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("大招：" + intSummaryStatistics);
        double average1 = intSummaryStatistics.getAverage();
        long count1 = intSummaryStatistics.getCount();
        System.out.println("大招average: " + average1 + ",大招count:" + count1);

        //连接字符串
        String nameJoin = list.stream().map(Dish::getName).collect(joining(","));
        System.out.println("nameJoin:" + nameJoin);  //nameJoin:food1,food12,food13

    }

    public static void streamTotal() {
        int total = list.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i + j));
        System.out.println("total: " + total);

        Optional<Dish> reduce = list.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2);
        reduce.ifPresent(dish -> System.out.println(dish));

        //分组
        Map<Integer, List<Dish>> groupMap = list.stream().collect(groupingBy(Dish::getCalories));
        System.out.println(groupMap);

        //二级分组
        Map<String, Map<String, List<Dish>>> groupMap2 = list.stream()
                .collect(Collectors.groupingBy(Dish::getType,
                        groupingBy((Dish dish) -> {
                                    if (dish.getCalories() <= 400) {
                                        return "低热量";
                                    } else if (dish.getCalories() <= 750) {
                                        return "还好";
                                    } else {
                                        return "高热量";
                                    }
                                }
                        ))
                );
        System.out.println("二级分组: " + groupMap2);

        //按照子组统计数据: 统计不同类型的数量
        Map<String, Long> groupCount = list.stream().collect(Collectors.groupingBy(Dish::getType, counting()));
        System.out.println("统计分组中的数量： " + groupCount);

        //求分组中的最大值
        Map<String, Optional<Dish>> groupMax = list.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));
        System.out.println("分组最大值: " + groupMax);

        //分组求和
        Map<String, Integer> summingGroup = list.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println("分组求和: " + summingGroup);

        //分组映射
        Map<String, Set<String>> groupMapping = list.stream().collect(groupingBy(Dish::getType,
                mapping((Dish dish) -> {
                    if (dish.getCalories() < 350) {
                        return "低热量";
                    } else if (dish.getCalories() < 700) {
                        return "还可以吧";
                    } else {
                        return "高热量";
                    }
                }, toSet()))
        );
        System.out.println("分组映射: " + groupMapping);

        //流分块
        Map<Boolean, List<Dish>> partition = list.stream().collect(partitioningBy(Dish::isVagetable));
        System.out.println("分区：" + partition);
        //流分区 二级map
        Map<Boolean, Map<String, List<Dish>>> collect = list.stream().collect(partitioningBy(Dish::isVagetable, groupingBy(Dish::getType)));
        System.out.println(collect);

        //分组 帅选
        Map<Boolean, Dish> collectMap = list.stream().collect(partitioningBy(Dish::isVagetable, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
        System.out.println("???:" + collectMap);

    }


    public static void main(String[] args) {

//        sampleStream();
        streamTotal();
    }
}
