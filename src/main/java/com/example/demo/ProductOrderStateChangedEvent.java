package com.example.demo;

public class ProductOrderStateChangedEvent extends BaseProductOrderEvent {

    public ProductOrderStateChangedEvent(KafkaProductOrder productOrder) {
        super(productOrder);
    }

}
