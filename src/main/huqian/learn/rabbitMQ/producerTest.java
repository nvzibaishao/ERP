package learn.rabbitMQ;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class producerTest {
    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Test
    public void testHello(){
        for(int i=0;i<10;i++){
            //一个队列里面可以塞进去多种类型的对象，不支持复杂对象
            rabbitTemplate.convertAndSend("hello",new String("hello world"+i));
            //rabbitTemplate.convertAndSend("hello",new consumerType("编号为",i));
        }
    }
}
