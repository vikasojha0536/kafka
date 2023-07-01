package com.example.demo;

public class MessageDTO {

    private String message;
    private String version;

    public String getMessage() {
        return message;
    }

    public MessageDTO setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public MessageDTO setVersion(String version) {
        this.version = version;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MessageDTO{");
        sb.append("message='").append(message).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
