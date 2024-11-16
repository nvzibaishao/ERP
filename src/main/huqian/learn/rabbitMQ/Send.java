package learn.rabbitMQ;

import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {
    private final  static String QueueName="myFirstQueue";

    @Test
    public void sendTest(){
        Connection connection=null;
        Channel channel=null;
        try {
            connection = ConnectionUntil.getConnection();
            //从连接里面创建管道
            channel = connection.createChannel();
            //声明队列
            channel.queueDeclare(QueueName, false, false, false, null);
            //消息内容
            String message="hello rabbitmq";
            channel.basicPublish("",QueueName,null,message.getBytes());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }catch (Exception e) {

        }finally {
            try {
                channel.close();
            } catch (IOException e) {
                System.out.println("管道关闭失败");
            } catch (TimeoutException e) {
                System.out.println("管道关闭超时");
            }
            try {
                connection.close();
            } catch (IOException e) {
                System.out.println("连接关闭失败");
            }

        }
    }

    @Test
    public void consumeTest(){
        Connection connection=null;
        Channel channel=null;
        try {
            connection = ConnectionUntil.getConnection();
            channel= connection.createChannel();
            channel.queueDeclare(QueueName,false,false,false,null);
            channel.basicConsume(QueueName,true,new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println("Received message: " + message);
                }
            });
        }catch (Exception e){

        }
        finally {
            try {
                channel.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
            try {
                connection.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
