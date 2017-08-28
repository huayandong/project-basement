package cn.taike.spring.multiThread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by huayandong on 17/8/28.
 */
@Service
public class AsyncTaskService {

    @Async
    public void executeAsyncTask(Integer num) {
        System.out.println("执行异步任务:" + num);
    }

    @Async
    public void executeAsyncTaskPlus(Integer num) {
        System.out.println("执行异步任务Plus:" + (num + 1));
    }
}
