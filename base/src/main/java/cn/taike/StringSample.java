package cn.taike;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by huayandong on 17/9/11.
 */
public class StringSample {

    static String abc = "my name .is boxfish mani come .f";

    public static void sampleString(String[] args) {
        int first = 20;
        int last = 24;

        System.out.println(abc.length());

        String substring = abc.substring(first, last);

        int previousPoint = abc.substring(0, first).lastIndexOf(".");
        if (previousPoint == -1) {
            previousPoint = (first - 10) < 0 ? 0 : (first - 10);
        }
        int nextPoint = abc.substring(last).indexOf(".");
        if (nextPoint == -1) {
            nextPoint = (last + 10) > abc.length() ? abc.length() : (last + 10);
        } else {
            nextPoint = last + nextPoint;
        }

        System.out.println("sub: " + abc.substring(previousPoint + 1, nextPoint));

        System.out.println(substring);
        System.out.println(previousPoint);
        System.out.println(nextPoint);

    }


    public static void stringTrim() {

        String str = "22, 33,44 , 55 ";
        String[] split = str.split(",");
        Map<String, Integer> indexMap = new HashMap<>();
        indexMap.put("x", Integer.valueOf(split[0].trim()));
        indexMap.put("y", Integer.valueOf(split[1].trim()));
        indexMap.put("w", Integer.valueOf(split[2].trim()));
        indexMap.put("h", Integer.valueOf(split[3].trim()));

        System.out.println(indexMap);

    }

    public static void main(String[] args) {
        stringTrim();
    }

}
