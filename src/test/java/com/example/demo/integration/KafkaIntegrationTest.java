package com.example.demo.integration;

//import com.example.demo.KafkaConsumer;
import com.example.demo.KafkaConsumer;
import com.example.demo.KafkaProducer;
import com.example.demo.MessageDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.SendResult;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;


@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = "my-topic", brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
public class KafkaIntegrationTest {

    @Autowired
    private KafkaProducer producer;

    @Autowired
    private KafkaConsumer consumer;

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Test
    public void testProducerAndConsumer() throws ExecutionException, InterruptedException {
        MessageDTO messageDTO = new MessageDTO().setMessage("my-message").setVersion("v1");
        CompletableFuture<SendResult<String, MessageDTO>> future = producer.sendMessage(messageDTO);
        await().atMost(Duration.ofSeconds(10)).untilAsserted(() ->
                        assertThat(consumer.getMessageDTO()).isNotNull()
                );

//        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("group-id", "true", embeddedKafkaBroker);
//        consumerProps.put("auto.offset.reset", "earliest"); // Reset offset to consume from the beginning
//        ConsumerRecord<?, ?> oneRecord = KafkaTestUtils.getOneRecord("localhost:9092", "group-id", "my-topic", 0, true, true, Duration.ofSeconds(10));
//        assertThat(oneRecord.value()).isEqualTo("my-message");


    }
}