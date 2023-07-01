package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class CustomDeserializer implements Deserializer<MessageDTO> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public MessageDTO deserialize(String topic, byte[] data) {
        try {
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), MessageDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
