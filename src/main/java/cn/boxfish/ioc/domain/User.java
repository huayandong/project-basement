package cn.boxfish.ioc.domain;


/**
 * Created by huayandong on 17/6/28.
 */
public class User {

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

    public void add() {
        System.out.println("name is: " + username + ",age is: " + age);
        userDao.domain();
    }

    //有参构造方式赋值
    public User(String username, Integer age, UserDao userDao) {
        this.username = username;
        this.age = age;
        this.userDao = userDao;
    }
}
