package learn.rabbitMQ;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class consumer {

    //最好不要像下面这样写，会重复消费的，合理的应该是一个队列一个消费者或者使用RabbitListener自带的并发功能
    /**@RabbitListener(queuesToDeclare = @Queue("hello"))
    public  void receive1(Message Message, Channel channel){
        try {
            // 处理消息
            String data = new String(Message.getBody());
            System.out.println(data);
            channel.basicAck(Message.getMessageProperties().getDeliveryTag(), false);  // 手动确认消息
        } catch (Exception e) {
            try {
                channel.basicNack(Message.getMessageProperties().getDeliveryTag(), false, true);  // 处理失败时拒绝消息
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    @RabbitListener(queuesToDeclare = @Queue("hello"))
    public  void receive2(Message Message, Channel channel){
        try {
            // 处理消息
            String data = new String(Message.getBody());
            System.out.println(data);
            channel.basicAck(Message.getMessageProperties().getDeliveryTag(), false);  // 手动确认消息
        } catch (Exception e) {
            try {
                channel.basicNack(Message.getMessageProperties().getDeliveryTag(), false, true);  // 处理失败时拒绝消息
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }*/
    /**
     *  RabbitMQ 重复消费问题的原因：
     *
     * 网络问题： 在分布式系统中，网络通信是不稳定的因素之一。如果生产者发送一条消息到 RabbitMQ 但尚未收到确认（acknowledgment），可能会导致 RabbitMQ 认为消息未被正确处理并重新发送。
     * 消费者故障： 消费者在处理消息时可能会发生故障，例如应用程序崩溃或因某种原因终止。如果 RabbitMQ 未收到消费者的确认消息，它可能会认为消息未被消费并重新发送。
     * 网络分区： 当分布式系统中的网络发生分区（网络隔离）时，可能会导致消息在不同部分之间重复传递。这是因为每个分区可能都会独立处理消息。
     * 消息重复传递策略： RabbitMQ 提供了不同的消息传递策略，例如“至少一次传递”和“最多一次传递”。这些策略可能会导致消息的重复传递，尤其在异常情况下。
     * 消费者超时设置不当： 如果消费者设置了较长的超时时间，在消费者未确认消息的情况下，RabbitMQ 可能会认为消息未被处理并重新发送。
     * @param message
     */
    //RabbitListener的并发示范,嘶,加了vpn后网络波动延迟导致重复消费,可能是我这边的ack还没有发过去那边就又尝试发了一次
    @RabbitListener(queuesToDeclare = @Queue("hello"))
    public void receive(Message message) {
        //解决方案，引入redis缓存
        
        String data = new String(message.getBody());
        System.out.println(data);

    }


}
