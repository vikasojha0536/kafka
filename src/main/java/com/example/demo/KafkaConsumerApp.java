package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KafkaConsumerApp {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "");
        properties.put("security.protocol", "SASL_SSL");
        properties.put("sasl.jaas.config", "");
        properties.put("sasl.mechanism", "PLAIN");
        properties.put("client.dns.lookup", "use_all_dns_ips");
        properties.put("value.deserializer", "com.example.demo.CustomDeserializer");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "group-test");
        try(KafkaConsumer<String, MessageDTO> kafkaConsumer = new KafkaConsumer<>(properties)) {
        List<String> topics =  new ArrayList<>();
        topics.add("my-topic");
      //  topics.add("my-topic-4");
        kafkaConsumer.subscribe(topics);
            while(true){
                ConsumerRecords<String, MessageDTO> records = kafkaConsumer.poll(10);
                for(ConsumerRecord<String, MessageDTO> record: records) {
                    System.out.printf("Topic %s, partition: %d, key: %s, value: %s%n",
                                      record.topic(), record.partition(), record.key(), record.value());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
