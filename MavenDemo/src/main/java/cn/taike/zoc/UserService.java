package cn.taike.zoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by huayandong on 17/7/14.
 */
@Service("userService")
public class UserService {

    /**
     * @Resource 与 @Autowired
     * 相同点：都是做bean注入时使用，都可以写在字段上和setter方法上；
     * 不同点：
     *  @Autowired
     *      1.是spring提供的注解；
     *      2.只能按照类型byType注入对象，默认情况下依赖对象必须存在；
     *      3.如果允许为mull值，它的request属性可以设置为false；
     *      4.结合@Qualifier注解一起使用，可以指定对象的名称；
     *
     *  @Resource
     *      1.是javaEE提供的注解；
     *      2.该注解是按照对象byName名称来注入的；
     *      3.有两个属性：name和type，name指的是解析bean的名字，type属性解析为bean的类型；
     *      4.如果使用name则使用byName自动注入，
     *        如果使用type则使用byType自动注入，
     *        如果都没使用则通过反射机制使用byName自动注入，如果没有匹配，则回退为原始类型进行匹配，
     *        如果同时使用则从spring的上下文中找到唯一的bean进行装配；
     *
     */

    //使用注解方式注入对象  Resource()
    @Resource(name = "userDao")
    private UserDao userDao;

//    @Autowired(required = false)
//    @Qualifier(value = "userDao")
//    private UserDao jdbc;

    public void fun() {
        System.out.println("service...");
        userDao.addDao();
    }

}
