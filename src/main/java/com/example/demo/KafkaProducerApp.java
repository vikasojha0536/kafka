package com.example.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducerApp {

	public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "<host>:9092");
        properties.put("security.protocol", "SASL_SSL");
        properties.put("sasl.jaas.config", "");
        properties.put("sasl.mechanism", "PLAIN");
        properties.put("client.dns.lookup", "use_all_dns_ips");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        try (KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties)) {
            for (int i = 0; i < 1; i++) {
                kafkaProducer.send(new ProducerRecord<>("my-topic", Integer.toString(i), "My message " + i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
