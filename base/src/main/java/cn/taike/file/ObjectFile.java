package cn.taike.file;

import cn.taike.entity.Book;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by huayandong on 17/5/26.
 */
public class ObjectFile {


    public static void resetCollection(List<Integer> list) {

        //自定义TreeSet排序、
        Set<Integer> set = Sets.newTreeSet(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        Set<Integer> set2 = Sets.newTreeSet(Integer::compareTo);
        list.forEach(it -> set2.add(it));
        set2.forEach(it -> System.out.println("打印:" + it));


        TreeSet<Book> treeSet = Sets.newTreeSet(Comparator.comparing(Book::getBookName));
    }

    public static void catchFile(File file) {
        File absoluteFile = file.getAbsoluteFile();
        String absolutePath = file.getAbsolutePath();
        String fileName = file.getName();
        boolean exists = file.exists();

        Path path = file.toPath();
    }

    static Integer a ;
    static boolean flag;
    static long al;
    static String st;

    public static void main(String[] args) {

        Integer b = null ;
        System.out.println("a:" + a);
        System.out.println("b:" + b);
        System.out.println("flag:" + flag);
        System.out.println("Long:" + al);
        System.out.println("String:" + st);




        File file1 = new File("/test/Hellen/");
        System.out.println("file1.getName:" + file1.getName());
        File file2 = new File("/test/Hellen/pageJson_dbUtils.json");
        System.out.println("file1.getName:" + file2.getName());

        boolean isEmpty = StringUtils.isEmpty(null);
        System.out.println("为空：" + isEmpty);

        String aaa = null;
        /**
         * StringUtils.isBlank() : sequence为空白 为null或者sequence长度为0
         */
        boolean blank = StringUtils.isBlank(aaa);
        System.out.println("aaa isBlank:" + blank);

    }
}
