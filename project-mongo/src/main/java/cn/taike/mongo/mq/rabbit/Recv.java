package cn.taike.mongo.mq.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by huayandong on 17/8/18.
 */
public class Recv {

    private static final String QUEUE_NAME = "queue";

    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        factory.setHost("127.0.0.1");
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Waiting for message.");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 指定消息队列
        channel.basicConsume(QUEUE_NAME, true, consumer);
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("receive message: " + message);
        }


    }

}
