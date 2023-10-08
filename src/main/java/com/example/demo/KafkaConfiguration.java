package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kafka")
public class KafkaConfiguration {

    private String topic;

    public String getTopic() {
        return topic;
    }

    public KafkaConfiguration setTopic(String topic) {
        this.topic = topic;
        return this;
    }
}
