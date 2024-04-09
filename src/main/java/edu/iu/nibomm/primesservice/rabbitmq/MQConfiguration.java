package edu.iu.nibomm.primesservice.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class MQConfiguration {

    @Bean
    public Queue queue(){
        return new Queue("primes");
    }
}
