package cn.taike.zop.sample;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/7/19.
 */
@Component
@Aspect
public class LogAspectj {

    private static final String ASPECT_PATH = "execution(* cn.taike.zop.sample.Book.del*(..))";

    @Pointcut(ASPECT_PATH)
    public void deleteMethod() {

    }

    //前置通知
    @Before(value = "deleteMethod()")
    public void beforeDelete() {
        System.out.println("before delete.....");
    }

    //后置通知(最终通知)
    @After(value = "deleteMethod()")
    public void afterDelete() {
        System.out.println("after delete.....");
    }


    //环绕通知
    @Around(value = "deleteMethod()")
    public void aroundDelete(ProceedingJoinPoint jointPoint) throws Throwable {
        System.out.println("环绕通知------前");

        long start = System.currentTimeMillis();
        //调用接口中的方法，促使被增强的方法执行
        jointPoint.proceed();
        long span = System.currentTimeMillis() - start;
        System.out.println("执行方法用时：" + span + "ms!");

        String name = jointPoint.getSignature().getName();
        System.out.println("执行的方法的名字是:" + name);

        System.out.println("环绕通知------后");
    }
}
