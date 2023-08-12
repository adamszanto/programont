package com.adam.kafkatutorial.kafka.payload;

public class UserAction {
    private UserActionHeader header;
    private String payload;

    public UserActionHeader getHeader() {
        return header;
    }

    public void setHeader(UserActionHeader header) {
        this.header = header;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "KafkaMessage{" +
                "header=" + header +
                ", payload='" + payload + '\'' +
                '}';
    }
}
