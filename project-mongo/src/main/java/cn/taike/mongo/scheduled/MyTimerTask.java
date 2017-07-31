package cn.taike.mongo.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huayandong on 17/7/29.
 */
@Component
public class MyTimerTask {

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 3000)  //每隔3秒执行一次
//    public void timeRate() {
//        System.out.println("执行时间: " + sdf.format(new Date()));
//    }
//
//    /**
//     * 定时执行任务参数：
//     *  @SCheduled(cron = "")
//     *   第一位，表示秒，取值0-59
//     *   第二位，表示分钟，表示0-59
//     *   第三位，表示小时，取值0-23
//     *   第四位，表示日期 天/日，取值1-31
//     *   第五位，表示日期 月份，取值1-12
//     *   第六位，表示星期，取值1-7，另注：1表示星期天，2表示星期一，...
//     *   第七位，表示年份，可以留空，取值1970-2099
//     */
//    @Scheduled(cron = "0/10 06 11 * * ?")
//    public void statusTask() {
//        System.out.println("定时执行任务: " + sdf.format(new Date()));
//    }

}
