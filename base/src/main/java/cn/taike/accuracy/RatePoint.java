package cn.taike.accuracy;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by huayandong on 17/6/22.
 */
public class RatePoint {

    //截取小数点后几位
    public static void cutRate1(double num, List<String> listm) {

        //Math.round()方法四舍五入
        long round = Math.round(num * 100);
        double value = ((double) round) / 100;
        System.out.println("Math:" + value);

        //java.math.BigDecimal 设置精度 和 舍入规范
        BigDecimal bd = new BigDecimal(num);
        double v = bd.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        System.out.println("BigDecimal:" + v);

        //java.text.DecimalFormat 格式化小数
        DecimalFormat df = new DecimalFormat("#.00");
        String format = df.format(num);
        System.out.println("DecimalFormat:" + format);

        //String.format()
        String format1 = String.format("%.2f", num);
        System.out.println("String.format:" + format1);

        //java.text.NumberFormat
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        String format2 = nf.format(num);
        System.out.println("NumberFormat:" + format2);

        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> list2 = Lists.newArrayList();

        List<Integer> integerList = Collections.emptyList();  //返回一个不可变的集合
        integerList.add(12);


        System.out.println(list2.isEmpty());

        Map<String, String> map = Maps.newHashMap();

        Map<String, String> map2 = Maps.transformEntries(map, new Maps.EntryTransformer<String, String, String>() {
            @Override
            public String transformEntry(String key, String value) {
                return null;
            }
        });

        Map<Integer, Integer> intMap = Maps.newHashMap();
        intMap.put(1, 3);
        intMap.put(2, 6);
        intMap.put(3, 9);
        Map<Integer, Integer> intMap0 = Maps.newHashMap(intMap);
        System.out.println("intMap0:" + intMap0);

        //根据集合的key-value来转换集合
        Map<Integer, Integer> intMap2 = Maps.transformEntries(intMap, new Maps.EntryTransformer<Integer, Integer, Integer>() {
            @Override
            public Integer transformEntry(Integer key, Integer value) {
                return key + value;
            }
        });
        System.out.println("intMap2:" + intMap2);//intMap2:{1=4, 2=8, 3=12}

        //根据集合的value来转换集合
        Map<Integer, Integer> intMap3 = Maps.transformValues(intMap, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer input) {
                return input * input;
            }
        });
        System.out.println("intMap3:" + intMap3);//intMap3:{1=9, 2=36, 3=81}


        map.put(null, null);
        map.put("kong", null);
        map.put(null, "kong value");
        System.out.println("map size: " + map.size());
        System.out.println("空value： " + map.get(null));
        System.out.println("kong ： " + map.get("kong"));


        System.out.println("参数为空：" + (list != null && !list.isEmpty()));


    }

    public static void main(String[] args) {
        cutRate1(10.665, null);
    }


}
