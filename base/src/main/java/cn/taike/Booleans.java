package cn.taike;

import org.apache.commons.lang3.BooleanUtils;

/**
 * Created by huayandong on 17/7/28.
 */
public class Booleans {

    public static void main(String[] args) {

        //参数都为true的时候返回值才为true;
        boolean andFlag = BooleanUtils.and(new boolean[]{true, true, true});
        System.out.println("andFlag:" + andFlag);

        //参数都为false的时候返回值才为false;
        boolean orFlag = BooleanUtils.or(new boolean[]{false, false, false});
        System.out.println("orFlag:" + orFlag);
    }
}
