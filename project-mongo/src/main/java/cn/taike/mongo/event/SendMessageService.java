package cn.taike.mongo.event;

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
    public void sendMessageService() {
        System.out.println("start send event ...");
        System.out.println("时间1: " + DateTime.now());

        applicationEventPublisher.publishEvent(new JsonCreateMessage("json: assert this is json. ", "student"));
    }
}
