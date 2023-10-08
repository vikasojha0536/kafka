package com.example.demo;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.SaslConfigs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "pkc-lzvrd.us-west4.gcp.confluent.cloud:9092");
//        configs.put(AdminClientConfig.SECURITY_PROTOCOL_CONFIG, "SASL_SSL");
//        configs.put(SaslConfigs.SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username='MTZWFWNEJTBZNN6A' password='kGXStUctydkkx3IDOXe1zgrsMALvLX8bHys1fHJlRWdmbZLi/6erXuhxRfwzXYZD';");
//        configs.put(SaslConfigs.SASL_MECHANISM, "PLAIN");
//        configs.put(CommonClientConfigs.CLIENT_DNS_LOOKUP_CONFIG, "use_all_dns_ips");
//        return new KafkaAdmin(configs);
//    }

//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Map<String, String>> kafkaListener() {
//        ConcurrentKafkaListenerContainerFactory<String, Map<String, String>> factory = new ConcurrentKafkaListenerContainerFactory<>();
//      //  factory.setConsumerFactory(consumerFactory());
//        factory.setBatchListener(true);
//        factory.getContainerProperties().setIdleBetweenPolls(10000);
//        return factory;
//    }

    @Bean
    public NewTopic testTopic() {
        return TopicBuilder.name("my-topic")
                .build();
    }
}
