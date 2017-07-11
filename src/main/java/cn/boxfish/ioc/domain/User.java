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

    public void add() {
        System.out.println("name is: " + username + ",age is: " + age);
    }
}
