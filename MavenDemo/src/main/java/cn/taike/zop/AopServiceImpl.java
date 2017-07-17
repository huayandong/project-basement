package cn.taike.zop;

import org.springframework.stereotype.Service;

/**
 * Created by huayandong on 17/7/14.
 */
@Service("aopServiceImpl")
public class AopServiceImpl implements AopService {
    @Override
    public void save() {
        System.out.println("面向切面------save方法");
    }

    @Override
    public void doAop() {
        System.out.println("面向切面------doAop方法");
    }
}
