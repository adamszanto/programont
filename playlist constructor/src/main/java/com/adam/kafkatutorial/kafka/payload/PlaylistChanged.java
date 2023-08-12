package com.adam.kafkatutorial.kafka.payload;

import java.util.List;
import java.util.Objects;

public class PlaylistChanged extends Event {
    private List<String> payload;

    public List<String> getPayload() {
        return payload;
    }

    public void setPayload(List<String> payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlaylistChanged that = (PlaylistChanged) o;
        return Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), payload);
    }

    @Override
    public String toString() {
        return "PlaylistChanged{" +
                "payload=" + payload +
                '}';
    }
}
