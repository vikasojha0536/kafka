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
        properties.put("bootstrap.servers", "<host>:9092");
        properties.put("security.protocol", "SASL_SSL");
        properties.put("sasl.jaas.config", "");
        properties.put("sasl.mechanism", "PLAIN");
        properties.put("client.dns.lookup", "use_all_dns_ips");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("group.id", "group-test");
        try(KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties)) {
        List<String> topics =  new ArrayList<>();
        topics.add("my-topic");
      //  topics.add("my-topic-4");
        kafkaConsumer.subscribe(topics);
            while(true){
                ConsumerRecords<String, String> records = kafkaConsumer.poll(10);
                for(ConsumerRecord<String, String> record: records) {
                    System.out.println(String.format("Topic %s, partition: %d, key: %s, value: %s",
                                                     record.topic(), record.partition(), record.key(), record.value()));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
