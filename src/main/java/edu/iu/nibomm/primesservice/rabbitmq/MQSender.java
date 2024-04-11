package edu.iu.nibomm.primesservice.rabbitmq;

import com.nimbusds.jose.shaded.gson.Gson;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.amqp.core.Queue;
import edu.iu.nibomm.primesservice.model.PrimesRecord;

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

    public void sendMessage(String customer ,int n , boolean isPrime){

        PrimesRecord message = new PrimesRecord(customer, n, isPrime);
        Gson gson = new Gson();
        String jsonMessage = gson.toJson(message);

        rabbitTemplate.convertAndSend("primes", jsonMessage);
    }
}
