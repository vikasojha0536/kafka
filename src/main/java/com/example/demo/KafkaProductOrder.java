package com.example.demo;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@JsonRootName(value = "ProductOrder")
@Builder
public class KafkaProductOrder {

    private String id;
    private String externalId;
    private String publicIdentifier;
    private StateEnum state;
    private String businessProcess;
    private String profileId;
    private String relatedParties;
    private List<KafkaOrderItem> orderItems;
    private List<KafkaProductOrderDelivery> deliveries;
}
