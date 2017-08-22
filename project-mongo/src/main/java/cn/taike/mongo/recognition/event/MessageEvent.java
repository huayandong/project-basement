package cn.taike.mongo.recognition.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * Created by huayandong on 17/8/22.
 */
@Data
public class MessageEvent extends ApplicationEvent {

    String name;

    public MessageEvent(Object source) {
        super(source);
    }

}
