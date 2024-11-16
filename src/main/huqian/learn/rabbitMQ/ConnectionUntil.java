package learn.rabbitMQ;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUntil {
    public  static Connection getConnection() throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置服务地址
        connectionFactory.setHost("117.72.96.47");
        //端口
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("myVH");
        connectionFactory.setUsername("huqian");
        connectionFactory.setPassword("huqian");
        Connection connection = connectionFactory.newConnection();
        return  connection;
    }

}
