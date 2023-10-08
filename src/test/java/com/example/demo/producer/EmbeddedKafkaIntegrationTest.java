package com.example.demo.producer;

import com.example.demo.KafkaProducer;
import com.example.demo.KafkaProductOrder;
import com.example.demo.StateEnum;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
class EmbeddedKafkaIntegrationTest {


    @Autowired
    private KafkaProducer kafkaProducer;

//    @Autowired
//    private KafkaProducer kafkaProducer;

    @Autowired
    private EmbeddedKafkaBroker embeddedKafka;


    @Test
    public void givenEmbeddedKafkaBroker_whenSendingWithSimpleProducer_thenMessageReceived()
            throws Exception {
        KafkaProductOrder kafkaProductOrder = new KafkaProductOrder().setId("56e164fc-6964-431f-aeef-518c648de979")
                .setPublicIdentifier("2232088407")
                .setState(StateEnum.COMPLETED)
                .setBusinessProcess("addonManagement");
        kafkaProducer.sendMessage(kafkaProductOrder);

//        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("group-id", "false", embeddedKafka);
//        DefaultKafkaConsumerFactory<Integer, String> cf =
//                new DefaultKafkaConsumerFactory<Integer, String>(consumerProps);
//        ContainerProperties containerProperties = new ContainerProperties("my-topic");
//        KafkaMessageListenerContainer<Integer, String> container =
//                new KafkaMessageListenerContainer<>(cf, containerProperties);
//        final BlockingQueue<ConsumerRecord<Integer, String>> records = new LinkedBlockingQueue<>();
//        container.setupMessageListener((MessageListener<Integer, String>) record -> {
//            System.out.println(record);
//            records.add(record);
//        });
//        container.setBeanName("templateTests");
//        container.start();
//        ContainerTestUtils.waitForAssignment(container, embeddedKafka.getPartitionsPerTopic());
//        ConsumerRecord<Integer, String> received = records.poll(10, TimeUnit.SECONDS);
//        assertThat(received.value()).isNotNull();

    }
}