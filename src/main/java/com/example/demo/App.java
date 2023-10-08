package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
        KafkaProductOrder kafkaProductOrder = KafkaProductOrder.builder()
                .id("56e164fc-6964-431f-aeef-518c648de979")
                .publicIdentifier("2232088407")
                .state(StateEnum.COMPLETED)
                .businessProcess("addonManagement")
//  TODO - in order item state change task
//                    .orderItems(
//                        orderEvent.getStateChanges() -- > individual items'list
//                    )
                .build();
        kafkaProducer.sendMessage(kafkaProductOrder);
    }
}
