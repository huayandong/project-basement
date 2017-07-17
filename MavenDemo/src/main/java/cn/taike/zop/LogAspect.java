package cn.taike.zop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/7/17.
 */
@Component
@Aspect
@Order(1)
public class LogAspect {

    private final String aopPath = "execution(* cn.taike.zop.AopServiceImpl.*(..))";

    @Pointcut(aopPath)
    public void anyMethod() {

    }

    @Before(value = "anyMethod()")
    public void before() {
        System.out.println("before...anyMethod");
    }

    @After(value = "anyMethod()")
    public void after() {
        System.out.println("after...anyMethod");
    }
}
