package cn.taike.mongo.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by huayandong on 17/8/22.
 */
public class Message extends ApplicationEvent {

    private String name;

    public Message(String source) {
        super(source);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
