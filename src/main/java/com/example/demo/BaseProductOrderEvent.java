package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseProductOrderEvent {

    private KafkaProductOrder kafkaProductOrder;
}