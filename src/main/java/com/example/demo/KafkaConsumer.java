package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private ProductOrderStateChangedEvent messageDTO;

    @KafkaListener(topics = "my-topic", groupId = "group-id")
    public void consume(@Payload ProductOrderStateChangedEvent productOrderStateChangedEvent) {
        this.messageDTO = productOrderStateChangedEvent;
        System.out.printf("Message received -> %s%n", messageDTO.toString());
    }

    public ProductOrderStateChangedEvent getMessageDTO() {
        return messageDTO;
    }

}
