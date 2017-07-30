package cn.taike.java8;

import cn.taike.entity.Dish;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Created by huayandong on 17/7/30.
 */
public class SampleStreamCollect {

    public static void sampleStream() {

        List<Dish> list = new ArrayList<>();
        Dish dish = new Dish(12, "food1", "Vagetable", 500);
        Dish dish2 = new Dish(124, "food12", "beef", 800);
        Dish dish3 = new Dish(125, "food13", "soup", 300);
        list.add(dish);
        list.add(dish2);
        list.add(dish3);

        //统计流中元素个数：
//        list.stream().collect(Collectors.counting());  同下
        long count = list.stream().count();
        System.out.println("count: " + count);

        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> collect = list.stream().collect(maxBy(dishComparator));
        collect.ifPresent(item -> System.out.println("最大值的对象：" + item));

        //两种去流中最大值得方式：
        list.stream().max(Comparator.comparingInt(Dish::getCalories));
        list.stream().mapToInt(Dish::getCalories).max();

        //求和
        list.stream().collect(summingInt(Dish::getCalories));
        int sum = list.stream().mapToInt(Dish::getCalories).sum();
        System.out.println("总和：" + sum);

    }


    public static void main(String[] args) {

    }
}
