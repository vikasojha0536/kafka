package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, MessageDTO> kafkaTemplate;

    public void sendMessage(MessageDTO messageDTO) throws ExecutionException, InterruptedException {
        Message<MessageDTO> message = MessageBuilder.withPayload(messageDTO)
                .setHeader(KafkaHeaders.TOPIC, "my-topic")
                .build();
        CompletableFuture<SendResult<String, MessageDTO>> result = kafkaTemplate.send(message);
        System.out.println("result "+result.get().getProducerRecord().partition());

    }

}
