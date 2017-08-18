package cn.taike.mongo.mq.rabbit;

import java.io.Serializable;

/**
 * Created by huayandong on 17/8/18.
 */
public class MessageInfo implements Serializable {
    private static final Long serialVersionUID = 1L;
    private String channel;
    private String content;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
