package cn.taike.zoc;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by huayandong on 17/7/14.
 */
@Service("userService")
public class UserService {

    //使用注解方式注入对象  Resource()
    @Resource(name = "userDao")
    private UserDao userDao;

    public void fun() {
        System.out.println("service...");
        userDao.addDao();
    }

}
