package com.adam.kafkatutorial.kafka.payload;

import java.util.Objects;

public class UserAction extends Event {
    private String payload;

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserAction that = (UserAction) o;
        return Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), payload);
    }

    @Override
    public String toString() {
        return "UserAction{" +
                "payload='" + payload + '\'' +
                '}';
    }
}
