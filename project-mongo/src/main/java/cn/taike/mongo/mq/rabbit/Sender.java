package cn.taike.mongo.mq.rabbit;

import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by huayandong on 17/8/18.
 */
public class Sender extends BasicConnector {

    public Sender(String queueName) throws Exception {
        super(queueName);
    }

    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish("", queueName, null, SerializationUtils.serialize(object));
    }
}
