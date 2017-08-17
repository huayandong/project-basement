package cn.taike.mongo.basement.context;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by huayandong on 17/8/17.
 */
public class DataFormatUtils {

    private static final ObjectMapper mapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .registerModule(new JodaModule());

    public static String toJsonNoException(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static String toJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    public static <T> T toEntity(String json, Class<T> type) throws IOException {
        return mapper.readValue(json, type);
    }

    public static <T> List<T> toListEntity(String json, Class<T> type) throws IOException {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, type);
        return mapper.readValue(json, javaType);
    }

    public static Map<String, String> toStringMapEntity(String json) throws IOException {
        return mapper.readValue(json.getBytes(), new TypeReference<Map<String, String>>() {
        });
    }

    public static <K, Y> Map<K, Y> toMapEntity(String json, Class<K> keyType, Class<Y> valueType) throws IOException {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(Map.class, keyType, valueType);
        return mapper.readValue(json, javaType);
    }

}
