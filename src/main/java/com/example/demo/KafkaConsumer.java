package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private MessageDTO messageDTO;

    @KafkaListener(topics = "my-topic", groupId = "group-id")
    public void consume(MessageDTO messageDTO) {
        this.messageDTO = messageDTO;
        System.out.printf("Message received -> %s%n", messageDTO.toString());
    }

    public MessageDTO getMessageDTO() {
        return messageDTO;
    }

}
