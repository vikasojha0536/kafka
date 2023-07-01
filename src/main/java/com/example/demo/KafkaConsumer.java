package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "group-id")
    public void consume(MessageDTO messageDTO) {
        System.out.printf("Message received -> %s%n", messageDTO.toString());
    }

}
