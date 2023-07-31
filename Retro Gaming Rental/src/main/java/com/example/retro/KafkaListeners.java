package com.example.retro;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "retroRental",
            groupId = "renting"
    )
    void listener(String data) {
        System.out.println("Listener received: " + data);
    }
}
