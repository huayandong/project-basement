package cn.taike.utils;

/**
 * Created by huayandong on 17/5/23.
 */
@FunctionalInterface
public interface Callback<P, R> {

    R callback(P param);
}
