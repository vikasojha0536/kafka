package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(KafkaConfiguration.class)
public class App implements CommandLineRunner {

    private final KafkaProducer kafkaProducer;

    public App(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MessageDTO messageDTO = new MessageDTO().setMessage("my-message").setVersion("v1");
        kafkaProducer.sendMessage(messageDTO);
    }
}
