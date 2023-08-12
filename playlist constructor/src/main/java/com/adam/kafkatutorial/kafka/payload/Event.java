package com.adam.kafkatutorial.kafka.payload;

import org.springframework.messaging.handler.annotation.Payload;

import java.util.Objects;

public abstract class Event {
    private EventHeader header;

    public EventHeader getHeader() {
        return header;
    }

    public void setHeader(EventHeader header) {
        this.header = header;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(header, event.header);
    }

    @Override
    public int hashCode() {
        return Objects.hash(header);
    }

    @Override
    public String toString() {
        return "Event{" +
                "header=" + header +
                '}';
    }
}
