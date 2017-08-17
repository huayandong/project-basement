package cn.taike.zoc;

import org.springframework.stereotype.Repository;

/**
 * Created by huayandong on 17/7/14.
 */
@Repository(value = "userDao")
public class UserDao {

    public void addDao() {
        System.out.println("jdbc......");
    }
}
