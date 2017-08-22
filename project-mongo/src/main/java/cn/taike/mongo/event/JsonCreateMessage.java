package cn.taike.mongo.event;

/**
 * Created by huayandong on 17/8/22.
 */
public class JsonCreateMessage extends Message {

    private String json;
    private String jsonType;

    public JsonCreateMessage(String json, String jsonType) {
        super(json);
        this.json = json;
        this.jsonType = jsonType;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getJsonType() {
        return jsonType;
    }

    public void setJsonType(String jsonType) {
        this.jsonType = jsonType;
    }
}
