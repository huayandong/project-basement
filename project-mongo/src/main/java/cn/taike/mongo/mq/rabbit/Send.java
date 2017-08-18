package cn.taike.mongo.mq.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by huayandong on 17/8/18.
 */
public class Send {

    private static final String QUEUE_NAME = "queue";

    public static void main(String[] args) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            String message = "This is a send message!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("Sent message:" + message);

            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
