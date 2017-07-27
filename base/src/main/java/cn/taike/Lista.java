package cn.taike;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.ListIterator;

import static java.util.stream.Collectors.toList;

/**
 * Created by huayandong on 17/7/27.
 */
public class Lista {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("f");

        list.forEach(i -> System.out.println("1:" + i));

        List<String> list2 = list.stream().distinct().collect(toList());
        ListIterator<String> iterator = list2.listIterator();
        while (iterator.hasNext()){
            String id = iterator.next();
            list.remove(id);
        }

//        list.removeAll(list2);
        list.forEach(i -> System.out.println("3:" + i));
    }
}
