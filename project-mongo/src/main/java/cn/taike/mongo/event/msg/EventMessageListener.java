package cn.taike.mongo.event.msg;

import cn.taike.mongo.event.SendMessageService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import javax.inject.Named;

/**
 * Created by huayandong on 17/8/22.
 */
@Named
public class EventMessageListener implements ApplicationListener<Message> {

    @Autowired
    private SendMessageService sendMessageService;

    @Override
    public void onApplicationEvent(Message event) {
        if (event instanceof JsonCreateMessage) {
            doEvent((JsonCreateMessage) event);
        }
    }

    private void doEvent(JsonCreateMessage message) {

        System.out.println("转发事件,时间2: " + DateTime.now());
        sendMessageService.getEvent(message.getJson(), message.getJsonType());
    }
}
