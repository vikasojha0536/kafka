package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "group-id")
    public void consume(@Payload MessageDTO messageDTO) {
        System.out.printf("Message received -> %s%n", messageDTO.toString());
    }

}
