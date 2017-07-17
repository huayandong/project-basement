package cn.taike.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

/**
 * Created by huayandong on 17/5/23.
 */
public class CallbackUtils {

    public static String callbackFun(Object object, Path path) {
        return callbackFun(object, path, param -> param);
    }

    //回调
    public static String callbackFun(Object object, Path path, Callback<String, String> callback) {
        String value = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(object);
            String callbackJson = null;
            if (callback != null) {
                callbackJson = callback.callback(json);
            }
            if (StringUtils.isNoneBlank(callbackJson)) {
                value = callbackJson;
            } else {
                value = json;
            }
            FileUtils.writeStringToFile(path.toFile(), value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("张三", "李四");
        Path path = Paths.get("/test", "abc.json");
        Set<String> set = Sets.newHashSet();
        //不使用回调函数
        callbackFun(list, path);
        //使用回调方法
        callbackFun(list, path, abc -> {
            return abc + "aHahahah...";
        });
    }

}


