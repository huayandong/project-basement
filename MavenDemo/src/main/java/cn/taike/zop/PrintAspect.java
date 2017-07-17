package cn.taike.zop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/7/17.
 */
@Component//加入到Ioc容器中
@Aspect//指定当前类为切面类
public class PrintAspect {

    private final String aopPath = "execution(* cn.taike.zop.AopServiceImpl.*(..))";

    @Pointcut(aopPath)
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void before() {
        System.out.println("开启事务");
    }

    @After(value = "pointCut()")
    public void after() {
        System.out.println("关闭事务");
    }
}
