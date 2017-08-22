package cn.taike.mongo.event;

import org.joda.time.DateTime;
import org.springframework.context.ApplicationListener;

import javax.inject.Named;

/**
 * Created by huayandong on 17/8/22.
 */
@Named
public class MessageService implements ApplicationListener<Message> {


    @Override
    public void onApplicationEvent(Message event) {
        if (event instanceof JsonCreateMessage) {
            doEvent((JsonCreateMessage) event);
        }
    }

    private void doEvent(JsonCreateMessage message) {
        System.out.println("时间2: " + DateTime.now());

        String jsonType = message.getJsonType();
        System.out.println("jsonType: " + jsonType);

        String json = message.getJson();
        System.out.println("json: " + json);
    }
}
