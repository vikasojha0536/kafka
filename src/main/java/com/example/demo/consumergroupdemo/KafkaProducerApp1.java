package com.example.demo.consumergroupdemo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerApp1 {

	public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties)) {
            for (int i = 0; i < 150; i++) {
                kafkaProducer.send(new ProducerRecord<>("my-topic-3",  "abcd"));
                System.out.println("Successfully produced");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
