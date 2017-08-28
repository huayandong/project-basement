package cn.taike.spring.multiThread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by huayandong on 17/8/28.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService service = context.getBean(AsyncTaskService.class);

        for (int i = 0; i < 10; i++) {
            service.executeAsyncTask(i);
            service.executeAsyncTaskPlus(i);
        }
    }
}
