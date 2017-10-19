package cn.taike.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Created by huayandong on 17/10/18.
 */
public class CheckJson {

    static ObjectMapper mapper = new ObjectMapper();

    public static Boolean isValidJson(String jsonStr) {

        if (!StringUtils.isNotBlank(jsonStr)) {
            return false;
        }

        // 1.
        try {
            JsonNode jsonNode = mapper.readTree(jsonStr);
            return jsonNode != null;
        } catch (JsonParseException e) {
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;

        // 2.
//        JsonElement element = new JsonParser().parse(jsonStr);
//        return element.isJsonObject();

    }

    public static String toJson() {
        TestUser user = new TestUser("zhangsan", "123");
        String s = null;
        try {
            s = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public static void main(String[] args) {

        String json = toJson();
//        String json = "";
//        String json = "{\"abc\":\"123\"}";

        Boolean validJson = isValidJson(json);
        System.out.println("is json valid:" + validJson);
    }

    @Data
    @NoArgsConstructor
    public static class TestUser {
        String name;
        String password;

        public TestUser(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }
}
