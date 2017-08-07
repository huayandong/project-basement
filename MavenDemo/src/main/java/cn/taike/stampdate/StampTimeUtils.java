package cn.taike.stampdate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huayandong on 17/8/7.
 */
public class StampTimeUtils {

    //将时间戳转换成时间
    public static String stampToDate(String stamp) {
        String result = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long lt = new Long(stamp);
            Date date = new Date(lt);
            result = format.format(date);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    //将时间转换成时间戳
    public static String dateToStamp(String date) {
        String result = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date formatDate = format.parse(date);
            long stamp = formatDate.getTime();
            result = String.valueOf(stamp);
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        String date = stampToDate("1499062830000");
        System.out.println("时间: " + date);
        String stamp = dateToStamp(date);
        System.out.println("时间戳: " + stamp);
    }
}
