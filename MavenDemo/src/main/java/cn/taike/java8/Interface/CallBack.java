package cn.taike.java8.Interface;

/**
 * Created by huayandong on 17/7/25.
 */
@FunctionalInterface
public interface CallBack<P, R> {

    R call(P param);
}
