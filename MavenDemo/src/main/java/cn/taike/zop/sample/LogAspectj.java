package cn.taike.zop.sample;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/7/19.
 */
@Component
@Aspect
public class LogAspectj {

    private static final String ASPECT_PATH = "execution(* cn.taike.zop.sample.Book.add*(..))";

    @Pointcut(ASPECT_PATH)
    public void deleteMethod() {

    }

    @Before(value = "deleteMethod()")
    public void beforeDelete() {
        System.out.println("before delete.....");
    }

    @After(value = "deleteMethod()")
    public void afterDelete() {
        System.out.println("after delete.....");
    }
}
