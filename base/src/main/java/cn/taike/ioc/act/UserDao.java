package cn.taike.ioc.act;

import java.util.List;
import java.util.Set;

/**
 * Created by huayandong on 17/7/11.
 */
public class UserDao {

    private List<String> address;
    private Set<Integer> integerSet;

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public void setIntegerSet(Set<Integer> integerSet) {
        this.integerSet = integerSet;
    }

    public void domain() {
        System.out.println("userdao......coming");
        address.forEach(i -> System.out.println("List item :" + i));
        integerSet.forEach(i -> System.out.println("set item :" + i));
    }
}
