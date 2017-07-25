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
        List<String> list = Lists.newArrayList(bookMap.values().toArray())
                .stream()
                .map(String::valueOf)
                .collect(toList());

        System.out.println("list:" + list.toString());
    }

    public static void main(String[] args) {
//        testStream();
        testMap();
    }
}
