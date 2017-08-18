package cn.taike.mongo.basement.context;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by huayandong on 17/8/18.
 */
public interface BeanToMap {

    default Map<String, Object> toMap() throws IllegalAccessException {
        Map<String, Object> map = new TreeMap<>();

        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            map.put(f.getName(), f.get(this));
        }
        return map;
    }
}
