package cn.taike.java8;

import cn.taike.entity.Book;
import com.google.common.collect.Lists;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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

    public static void createStream() {
        //静态方法创建stream
        Stream<String> newStream = Stream.of("java", "php", "mongo");
        newStream.map(String::toUpperCase).forEach(System.out::println);

        //数组方式创建stream
        int[] a = {1, 3, 5, 34, 45, 23, 2, 26, 0};
        int sum = Arrays.stream(a).sum();
        System.out.println("sum: " + sum);

        //文件生成流
        String src = "/Users/huayandong/Desktop";
        try (Stream<String> stream = Files.lines(Paths.get(src, "604.txt"), Charset.defaultCharset())) {
            long count = stream.
                    flatMap(line -> Arrays.stream(line.split(""))).
                    distinct().
                    count();
            System.out.println("???: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //迭代 创建流
        Stream.iterate(0, n -> n + 1)
                .limit(5)
                .forEach(i -> System.out.println("iterator: " + i));

        //生成 创建流
        Stream.generate(Math::random)
                .limit(4)
                .distinct()
                .forEach(i -> System.out.println("generate: " + i));

        Stream.generate(() -> "generate.....").limit(6).forEach(System.out::println);
        Stream.iterate(0, n -> n - 2).limit(5).forEach(i -> System.out.println("iterator test: " + i));

        //迭代流的应用：
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(8)
                .forEach(item -> System.out.print("(" + item[0] + "," + item[1] + "), "));

    }


    public static void main(String[] args) {
//        testStreams();
        createStream();
    }
}
