package cn.taike.mongo.mq.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by huayandong on 17/8/18.
 */
public class BasicConnector {

    protected Channel channel;
    protected Connection connection;
    protected String queueName;

    public BasicConnector(String queueName) throws IOException, TimeoutException {
        this.queueName = queueName;

        // open connection
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");

        // 创建连接
        connection = factory.newConnection();
        channel = connection.createChannel();

        // 声明创建队列
        channel.queueDeclare(queueName, false, false, false, null);
    }

}
