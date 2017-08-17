package cn.taike.mongo.basement.exception;

/**
 * Created by huayandong on 17/8/17.
 */
public class IllegalUserTokenException extends Exception {
    public IllegalUserTokenException() {
    }

    public IllegalUserTokenException(String msg) {
        super(msg);
    }
}
