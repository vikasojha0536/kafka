package com.example.demo;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value = "OrderItem")
public class KafkaOrderItem {

    private String id;
    private String businessProcess;
    private StateEnum state;
}