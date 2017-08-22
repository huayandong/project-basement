package cn.taike.mongo.event.msg;

import lombok.Data;

/**
 * Created by huayandong on 17/8/22.
 */
@Data
public class JsonCreateMessage extends Message {

    private String json;
    private String jsonType;

    public JsonCreateMessage(String json, String jsonType) {
        super(json);
        this.json = json;
        this.jsonType = jsonType;
    }

}
