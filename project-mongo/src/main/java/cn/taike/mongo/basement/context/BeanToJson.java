package cn.taike.mongo.basement.context;

/**
 * Created by huayandong on 17/8/17.
 */
public interface BeanToJson {

    // default
    default String toJsonNoException() {
        return DataFormatUtils.toJsonNoException(this);
    }
}
