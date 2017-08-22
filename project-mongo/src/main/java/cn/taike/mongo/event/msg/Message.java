package cn.taike.mongo.event.msg;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * Created by huayandong on 17/8/22.
 */
@Data
public class Message extends ApplicationEvent {

    private String name;

    public Message(String source) {
        super(source);
    }

}
