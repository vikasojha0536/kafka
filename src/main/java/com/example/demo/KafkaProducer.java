package com.example.demo;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, MessageDTO> kafkaTemplate;

    public void sendMessage(KafkaProductOrder kafkaProductOrder) throws ExecutionException, InterruptedException {
        MessageDTO messa = new MessageDTO().setMessage("tets").setVersion("1");
//        Message<MessageDTO> message = MessageBuilder.withPayload(messa)
//                .setHeader(KafkaHeaders.TOPIC, "my-topic")
//                .build();

        List<Header> headers = new ArrayList<>();
        RecordHeader recordHeader = new RecordHeader("key","test".getBytes(StandardCharsets.UTF_8));
        headers.add(recordHeader);
        ProductOrderStateChangedEvent productOrderStateChangedEvent = new ProductOrderStateChangedEvent(kafkaProductOrder);
        final ProducerRecord<String, MessageDTO> record =
                new ProducerRecord<>("my-topic", null, 1L, "1", messa,headers);


        CompletableFuture<SendResult<String, MessageDTO>> result = kafkaTemplate.send(record);
        System.out.println("result "+result.get().getProducerRecord().partition());

    }

}
