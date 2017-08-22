package cn.taike.mongo.event;

import cn.taike.mongo.event.msg.JsonCreateMessage;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * Created by huayandong on 17/8/22.
 */
@Service
public class SendMessageService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    // send event
    public UserEvent sendMessageService() {
        System.out.println("start send event ...");
        System.out.println("时间1: " + DateTime.now());

        UserEvent userEvent = new UserEvent();
        userEvent.setJson("json: assert this is json.");
        userEvent.setJsonType("student");

        applicationEventPublisher.publishEvent(new JsonCreateMessage(userEvent.getJson(), userEvent.getJsonType()));

        return userEvent;
    }


    // get event
    public void getEvent(String json, String jsonType) {

        System.out.println("jsonType: " + jsonType);
        System.out.println("json: " + json);

        System.out.println("完成事件，事件3: " + DateTime.now());
    }

    @Data
    public static class UserEvent {
        private String json;
        private String jsonType;

    }

}
