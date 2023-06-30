package com.example.demo.consumergroupdemo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KafkaConsumer1 {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "group-test");

        try(KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties)) {
        List<String> topics =  new ArrayList<>();
        topics.add("my-topic-3");
        kafkaConsumer.subscribe(topics);
            while(true){
                ConsumerRecords<String, String> records = kafkaConsumer.poll(10);
                for(ConsumerRecord<String, String> record: records) {
                    System.out.printf("Topic %s, partition: %d, key: %s, value: %s%n",
                                      record.topic(), record.partition(), record.key(), record.value().toUpperCase());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
