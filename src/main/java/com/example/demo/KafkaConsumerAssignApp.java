package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class KafkaConsumerAssignApp {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "");
        properties.put("security.protocol", "SASL_SSL");
        properties.put("sasl.jaas.config", "");
        properties.put("sasl.mechanism", "PLAIN");
        properties.put("client.dns.lookup", "use_all_dns_ips");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        try(KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties)) {
        List<TopicPartition> partitions =  new ArrayList<>();
        TopicPartition partition0 = new TopicPartition("my-topic", 0);
        TopicPartition partition1 = new TopicPartition("my-topic", 2);
        partitions.add(partition0);
        partitions.add(partition1);
        kafkaConsumer.assign(partitions);
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
