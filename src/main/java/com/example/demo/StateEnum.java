package com.example.demo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StateEnum {
    ACKNOWLEDGED("acknowledged"),
    
    ACCEPTED("accepted"),
    
    REJECTED("rejected"),
    
    INPROGRESS("inProgress"),
    
    PENDING("pending"),
    
    HELD("held"),
    
    CANCELLED("cancelled"),
    
    COMPLETED("completed"),
    
    FAILED("failed"),
    
    PARTIAL("partial"),
    
    PROVISIONED("provisioned"),
    
    PENDINGCANCELLATION("pendingCancellation");

    private String value;

    StateEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StateEnum fromValue(String value) {
      for (StateEnum b : StateEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }