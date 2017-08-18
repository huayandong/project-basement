package cn.taike.mongo.mq.rabbit;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;

/**
 * Created by huayandong on 17/8/18.
 */
public class Receiver extends BasicConnector implements Runnable, Consumer {


    public Receiver(String queueName) throws Exception {
        super(queueName);
    }

    // Runnable的run方法
    @Override
    public void run() {
        try {
            channel.basicConsume(queueName, true, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer: " + consumerTag + "registered");
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        MessageInfo info = (MessageInfo) SerializationUtils.deserialize(body);
        System.out.println("Message(" + info.getChannel() + "," + info.getContent() + ")");
    }

    @Override
    public void handleCancelOk(String consumerTag) {

    }

    @Override
    public void handleCancel(String consumerTag) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {

    }

    @Override
    public void handleRecoverOk(String consumerTag) {

    }


}
