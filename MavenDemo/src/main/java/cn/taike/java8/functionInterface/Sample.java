package cn.taike.java8.functionInterface;

import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

/**
 * Created by huayandong on 17/7/31.
 */
public class Sample {

    public static void doFunction(Funnable funnable) {
        funnable.fun();
    }

    public static void doCallback(String json, CallBack<String, List<String>> callBack) {
        List<String> list = callBack.call(json);

        System.out.println("functionInterface: " + list);
    }

    public static void doCallback(CallBack<String, String> callBack) {
        System.out.println(callBack.call("abc"));
    }

    public static void doPredicate(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(item -> {
            if (predicate.test(item)) {
                System.out.println(item);
            }
        });
    }

    public static void localDataTimeSample() {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间:" + currentTime);

        LocalDate localDate = LocalDate.now();
        System.out.println("当前日期：" + localDate);

        System.out.println("年：" + currentTime.getYear() + "月：" + currentTime.getMonth() + ",日：" + currentTime.getDayOfMonth() + ",小时：" + currentTime.getHour() + ",分钟：" + currentTime.getMinute() + ",秒：" + currentTime.getSecond());
    }


    public static void main(String[] args) {

        doFunction(() -> System.out.println("hello"));

        String json = "hello-json-function-interface-great-stream-java-8-in-action";
        doCallback(json, hello -> Arrays.stream(hello.split("-"))
                .map(String::toUpperCase)
                .distinct()
                .filter(item -> item.length() > 3)
                .collect(toList()));

        IntBinaryOperator operator = (int a, int b) -> a + b;
        int i = operator.applyAsInt(1, 2);
        System.out.println(i); // 3


        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        doPredicate(list, it -> it % 2 == 0);


        localDataTimeSample();

        CallBack<String, String> a = String::toUpperCase;
        doCallback(a);
//        System.out.println("???:" + a);
    }

}
