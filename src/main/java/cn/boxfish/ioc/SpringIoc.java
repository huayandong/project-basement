package cn.boxfish.ioc;

import cn.boxfish.ioc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by huayandong on 17/6/26.
 */
public class SpringIoc {

    @Autowired
    @Qualifier(value = "user")
    private User user;


    public static void main(String[] args) {

    }


}
