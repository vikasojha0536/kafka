package com.example.demo;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaProducerApp {

	public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "");
        properties.put("security.protocol", "SASL_SSL");
        properties.put("sasl.jaas.config", "");
        properties.put("sasl.mechanism", "PLAIN");
        properties.put("client.dns.lookup", "use_all_dns_ips");
        properties.put("value.serializer", "com.example.demo.CustomSerializer");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        try (KafkaProducer<String, MessageDTO> kafkaProducer = new KafkaProducer<>(properties)) {
            for (int i = 0; i < 5; i++) {
                MessageDTO messageDTO = new MessageDTO().setMessage("my message "+i).setVersion("v"+i);
                Future<RecordMetadata> metadata = kafkaProducer.send(new ProducerRecord<>("my-topic", Integer.toString(i), messageDTO));
                RecordMetadata recordMetadata = metadata.get();
                System.out.printf("Partition %s, offset %s%n", recordMetadata.partition(), recordMetadata.offset());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
