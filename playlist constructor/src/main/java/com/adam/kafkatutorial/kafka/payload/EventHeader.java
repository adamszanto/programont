package com.adam.kafkatutorial.kafka.payload;

import java.time.Instant;

public class EventHeader {
    private String messageId;
    private Instant timestamp;
    private Action type;
    private String ownerId;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Action getType() {
        return type;
    }

    public void setType(Action type) {
        this.type = type;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "KafkaMessageHeader{" +
                "messageId='" + messageId + '\'' +
                ", timestamp=" + timestamp +
                ", type=" + type +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
