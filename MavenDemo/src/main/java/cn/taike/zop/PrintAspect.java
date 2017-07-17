package cn.taike.zop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by huayandong on 17/7/17.
 */
@Component//加入到Ioc容器中
@Aspect//指定当前类为切面类
@Order(2)//注解方式为同一个方法中的多个切面排序，数字越小表示优先权越高
public class PrintAspect {

    private final String aopPath = "execution(* cn.taike.zop.AopServiceImpl.*(..))";

    @Pointcut(aopPath)
    public void pointCut() {

    }

    @Before(value = "pointCut()")  //是在所拦截方法执行之前执行一段逻辑。
    public void before() {
        System.out.println("aop....开启");
    }

    @After(value = "pointCut()")  //是在所拦截方法执行之后执行一段逻辑。
    public void after() {
        System.out.println("aop....关闭");
    }


//    @Around(value = "pointCut()")   //是可以同时在所拦截方法的前后执行一段逻辑。
//    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        Object[] object = joinPoint.getArgs();
//        Object obj = joinPoint.proceed();
//        long span = System.currentTimeMillis() - start;
//
//        System.out.println(span + "000---000" + span);
//        return obj;
//    }
}
