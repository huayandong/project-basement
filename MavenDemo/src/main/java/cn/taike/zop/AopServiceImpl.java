package cn.taike.zop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by huayandong on 17/7/14.
 */
@Service("aopServiceImpl")
public class AopServiceImpl implements AopService {
    @Override
    public void save() {
        System.out.println("接口实现类中在保存。。。");
    }

    @Override
    public void doAop() {
        System.out.println("接口实现类中zop。。。");
    }
}
