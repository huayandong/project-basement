package cn.taike.java8;

import cn.taike.entity.Book;
import com.google.common.base.*;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Created by huayandong on 17/7/24.
 */
public class CollectionStream {

    public static void testStream() {

        List<Book> bookList = Lists.newArrayList();
        Book book1 = new Book("bookName1", "project1", "1");
        Book book2 = new Book("bookName2", "project2", "0");
        Book book3 = new Book("Name3", "project3", "3");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        List<String> book4 = bookList.stream()
                .filter(book -> book.getBookName().startsWith("book"))
                .filter(book -> book.getProjectName().endsWith("2"))
                .sorted(Comparator.comparing(Book::getType))
                .map(Book::getBookName)
                .collect(toList());

        Stream<Book> bookStream = bookList.stream()
                .filter(book -> book.getBookName().startsWith("book"))
                .filter(book -> book.getProjectName().endsWith("2"))
                .sorted(Comparator.comparing(Book::getType));

        System.out.println(bookStream);

//        book4.forEach(System.out::println);
        book4.forEach(item -> System.out.println("书名：" + item));

        Stream stream = Stream.of();
    }


    public static void testMap() {
        Map<Integer, String> bookMap = Maps.newHashMap();
        bookMap.put(1, "bob");
        bookMap.put(2, "tom");
        bookMap.put(3, "alice");

        //java8流的方式处理：将流中元素类型由Object转换成String
        //也可以使用toSet()结束流，返回的是Set<String>集合
        List<String> list = Lists.newArrayList(bookMap.values().toArray())
                .stream()
                .map(String::valueOf)
                .collect(toList()); //.collect(toSet());
        System.out.println("list:" + list.toString());

        //reduce方法：
        Long reduce = Stream.iterate(1L, i -> i + 1).
                limit(10).
                reduce(0L, Long::sum);
        System.out.println("what it is: " + reduce);
    }

    //flatMap:将一个流中的每一个值都换成另一个流，然后把所有的流连接起来成为一个流
    public static void testFlatMap() {
        List<String> list = Lists.newArrayList("hello", "world");

        List<String> collect = list.stream()
                .map(item -> item.split(""))  //遍历集合中的元素，将元素的字母拆分，返回的是Stream<String[]>
                .flatMap(Arrays::stream)        //将流中的元素拆分为流，并合并成为一个流
//                .flatMap(i -> Arrays.stream(i))
                .distinct()                 //合并后的流去重
                .collect(toList());

        System.out.println(collect);
        System.out.println(collect.size());


        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        List<Integer> list2 = Lists.newArrayList(3, 4);

        //使用flatMap 扁平化处理
        List<int[]> flatList = list1.stream()
                .flatMap(i -> list2.
                        stream().
                        map(j -> new int[]{i, j}))
                .collect(toList());
        System.out.println("flatMap: " + flatList);

        //未使用flatMap TODO ？？？↓
        List<Stream<int[]>> mapList2 = list1.stream()
                .map(i -> list2.
                        stream()
                        .map(j -> new int[]{i, j}))
                .collect(toList());
        System.out.println(mapList2);
    }

    public static void numberStream() {
        List<Book> bookList = Lists.newArrayList();
        Book book1 = new Book("bookName1", "project1", "1");
        Book book2 = new Book("bookName2", "project2", "0");
        Book book3 = new Book("Name3", "project3", "3");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        //reduce：求和、最大值/最小值、将多个值递归为一个值
        int number = bookList.stream()
                .mapToInt(i -> Integer.parseInt(i.getType()))
                .sum();
        System.out.println("sum is: " + number);
        //min
        int reduceMin = bookList.stream().mapToInt(i -> Integer.parseInt(i.getType())).reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println("reduce min: " + reduceMin);
        //max
        int reduceMax = bookList.stream().mapToInt(i -> Integer.parseInt(i.getType())).reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("reduce max: " + reduceMax);
        //string的拼接
        bookList.stream().map(Book::getBookName).reduce((a, b) -> a + "~" + b).ifPresent(i -> System.out.println("reduce name: " + i));
//        System.out.println("reduce name: " + reduce);

        //streamMax
        OptionalInt streamMax = bookList.stream()
                .mapToInt(i -> Integer.parseInt(i.getType()))
                .max();
        if (streamMax.isPresent()) {
            streamMax.ifPresent(i -> System.out.println("max:" + i));
        }

        //streamMin
        bookList.stream()
                .mapToInt(i -> Integer.parseInt(i.getType()))
                .min()
                .ifPresent(i -> System.out.println("min:" + i));

        //findAny：findany不是查找流中的全部元素,实则为第一个元素
        bookList.stream().findAny().map(Book::getBookName).ifPresent(name -> System.out.println("name:" + name));
    }

    public static void main(String[] args) {
//        testStream();
//        testMap();
//        testFlatMap();
        numberStream();
    }
}
