package cn.taike.ioc.act;


import org.apache.commons.lang3.ArrayUtils;

import java.util.Map;

/**
 * Created by huayandong on 17/6/28.
 */
public class UserService {

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    private Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private String[] array;
    private Map<String, Integer> map;

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public void add() {
        System.out.println("name is: " + username + ",age is: " + age);
        System.out.println(ArrayUtils.toString(array));
        System.out.println(map.toString());
        map.forEach((s, i) -> {
            System.out.println("key :" + s);
            System.out.println("value :" + i);
        });
        userDao.domain();
    }

    //有参构造方式赋值
//    public UserService(String username, Integer age, UserDao userDao) {
//        this.username = username;
//        this.age = age;
//        this.userDao = userDao;
//    }
}
