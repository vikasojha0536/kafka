/*
package com.example.demo;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, MessageDTO> producerFactory() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-lzvrd.us-west4.gcp.confluent.cloud:9092");
        configs.put(AdminClientConfig.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
        configs.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username='MTZWFWNEJTBZNN6A' password='kGXStUctydkkx3IDOXe1zgrsMALvLX8bHys1fHJlRWdmbZLi/6erXuhxRfwzXYZD';");
        configs.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
        configs.put(CommonClientConfigs.CLIENT_DNS_LOOKUP_CONFIG, "use_all_dns_ips");
        configs.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        configs.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);
        configs.put("spring.kafka.consumer.properties.spring.json.trusted.packages","*");
        return new DefaultKafkaProducerFactory<>(configs);
    }

    @Bean
    public KafkaTemplate<String, MessageDTO> kafkaTemplate() {
        return new KafkaTemplate<String, MessageDTO>(producerFactory());
    }
}
*/
