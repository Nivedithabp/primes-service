package edu.iu.nibomm.primesservice.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;

import java.text.MessageFormat;

@Component
public class MQSender {

    private final Queue queue;
    private final RabbitTemplate rabbitTemplate;
    public MQSender(Queue queue , RabbitTemplate re
    ){
        this.queue = queue;
        this.rabbitTemplate = re;
    }

    public void sendMessage(int n , boolean isPrime){
        String message = MessageFormat.format("n : {0} , isprime :{1}" , n , isPrime);
        rabbitTemplate.convertAndSend("primes",message);
    }
}
