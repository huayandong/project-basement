package cn.taike.commons;

/**
 * Created by huayandong on 17/7/10.
 */

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.SetUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 判断集合为空
 *  单列集合：CollectionUtils.isEmpty(Set/List set/list);
 *      ListUtils 和 SetUtils 中没重写isEmpty()方法
 *  双列集合：MapUtils.isEmpty(Map map);
 *
 */
public class Lists {

    public static void main(String[] args) {

        List<String> list1 = com.google.common.collect.Lists.newArrayList();
        List<String> list2 = com.google.common.collect.Lists.newArrayList("Caocao", "Simayi");
        System.out.println("list1 is empty :" + list1.isEmpty());
        System.out.println("list2 is empty :" + CollectionUtils.isEmpty(list2));

        Set<String> set = Sets.newHashSet();
        CollectionUtils.isEmpty(set);


        Map<String, String> map0 = Maps.newHashMap();
        Map<String, String> map1 = Maps.newHashMap();
        map1.put(null, null);
        Map<String, String> map2 = Maps.newHashMap();
        map2.put("sikong", "Caocao");
        map2.put("zhibo", "yangxiu");

        System.out.println("0: " + map0.isEmpty());
        System.out.println("1: " + new HashMap<>().isEmpty());
        System.out.println("2: " + map2.isEmpty());


        System.out.println("0_0: " + MapUtils.isEmpty(map0));
        System.out.println("1_1: " + MapUtils.isEmpty(new HashMap<>()));
        System.out.println("2_2: " + MapUtils.isEmpty(map2));

    }
}
