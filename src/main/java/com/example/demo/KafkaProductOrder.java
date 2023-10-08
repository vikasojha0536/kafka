package com.example.demo;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

//@Data
//@JsonRootName(value = "ProductOrder")
//@Builder
//@AllArgsConstructor
public class KafkaProductOrder {

    private String id;
    private String externalId;
    private String publicIdentifier;
    private StateEnum state;
    private String businessProcess;
    private String profileId;
    private String relatedParties;
  //  private List<KafkaOrderItem> orderItems;
 //   private List<KafkaProductOrderDelivery> deliveries;


    public String getId() {
        return id;
    }

    public KafkaProductOrder setId(String id) {
        this.id = id;
        return this;
    }

    public String getExternalId() {
        return externalId;
    }

    public KafkaProductOrder setExternalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    public String getPublicIdentifier() {
        return publicIdentifier;
    }

    public KafkaProductOrder setPublicIdentifier(String publicIdentifier) {
        this.publicIdentifier = publicIdentifier;
        return this;
    }

    public StateEnum getState() {
        return state;
    }

    public KafkaProductOrder setState(StateEnum state) {
        this.state = state;
        return this;
    }

    public String getBusinessProcess() {
        return businessProcess;
    }

    public KafkaProductOrder setBusinessProcess(String businessProcess) {
        this.businessProcess = businessProcess;
        return this;
    }

    public String getProfileId() {
        return profileId;
    }

    public KafkaProductOrder setProfileId(String profileId) {
        this.profileId = profileId;
        return this;
    }

    public String getRelatedParties() {
        return relatedParties;
    }

    public KafkaProductOrder setRelatedParties(String relatedParties) {
        this.relatedParties = relatedParties;
        return this;
    }
}
