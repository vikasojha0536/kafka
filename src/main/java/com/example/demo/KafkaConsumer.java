package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "topic_7", groupId = "group-id")
    public void consume(@Payload KafkaProductOrder kafkaProductOrder) {
        System.out.printf("Message received -> %s%n", kafkaProductOrder.toString());
    }

}
