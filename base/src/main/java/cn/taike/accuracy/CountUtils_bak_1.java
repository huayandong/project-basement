package cn.taike.accuracy;


import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by huayandong on 17/6/21.
 */
public class CountUtils_bak_1 {

    public static List<Double> calculate(int... list) {
        List<Integer> intList = Lists.newArrayList();
        for (int i : list) {
            intList.add(i);
        }
        return calculate(intList);
    }

    static double maxFloat = 0;
    static double maxFloatValue = 0;

    public static List<Double> calculate(List<Integer> list) {

        List<Double> resultList = Lists.newArrayList();

        double sum = 0;
        for (int i : list) {
            sum += i;
        }

        for (Integer i : list) {
            double v = handleResult(i / sum);

            double abs = Math.abs(v - (i / sum));
            if (maxFloat < abs) {
                maxFloat = abs;
                maxFloatValue = v;
            }

            resultList.add(v);
        }
        return checkResult(resultList);

    }

    public static double handleResult(double handleNum) {

        BigDecimal bd = new BigDecimal(handleNum);
        return bd.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue();
    }

    public static List<Double> checkResult(List<Double> result) {

        double sum = 0;
        for (double item : result) {
            System.out.println(item);
            sum += item;
        }
        System.out.println("总和：" + sum);

        if (sum > 1.0) {

            ListIterator listIterator = result.listIterator();
            while (listIterator.hasNext()) {
                if (Double.valueOf(String.valueOf(listIterator.next())) == maxFloatValue) {
                    listIterator.remove();
                    listIterator.add(handleResult(maxFloatValue - (sum - 1.0)));
                }
            }
            return result;

        } else if (sum < 1.0) {

            ListIterator listIterator = result.listIterator();
            while (listIterator.hasNext()) {
                if (Double.valueOf(String.valueOf(listIterator.next())) == maxFloatValue) {
                    listIterator.remove();
                    listIterator.add(handleResult(maxFloatValue + (1.0 - sum)));


                }

            }
            return result;

        } else {
            return result;
        }
    }


    public static void main(String[] args) {
//        List<Double> calculate = calculate(33, 54, 77, 97, 11, 13, 17, 23, 29);
//        List<Double> calculate = calculate(3, 5, 7, 9, 11, 13, 17, 29, 23);
        List<Double> calculate = calculate(3, 3, 3, 3, 3, 3, 3, 3, 3);
        System.out.println(calculate);
    }
}
