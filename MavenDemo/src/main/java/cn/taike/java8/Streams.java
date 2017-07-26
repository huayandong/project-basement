package cn.taike.java8;

import cn.taike.entity.Book;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by huayandong on 17/7/26.
 */
public class Streams {

    private static List<Book> bookList = Lists.newArrayList(
            new Book("bookName1", "project1", "1"),
            new Book("bookName2", "project2", "0"),
            new Book("Name3", "project3", "3")
    );

    //数值流与对象流
    public static void testStreams() {
        IntStream intStream = bookList.stream().mapToInt(book -> Integer.parseInt(book.getType()));//将stream转换成IntStream
        Stream<Integer> boxed = intStream.boxed(); //将intStream封装箱

    }


    public static void main(String[] args) {
        testStreams();
    }
}
