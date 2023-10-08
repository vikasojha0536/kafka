package com.example.demo;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value = "ProductOrderDelivery")
public class KafkaProductOrderDelivery {

    private String id;
    private String entityReferredType;

}
