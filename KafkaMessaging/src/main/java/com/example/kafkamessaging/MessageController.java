package com.example.kafkamessaging;

import com.example.kafkamessaging.model.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {
    private final KafkaTemplate<String, Message> kafkaTemplate;
    private final List<Message> messages = new ArrayList<>();

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody Message message) {
        message.setTime(Instant.now());
        kafkaTemplate.send("chat", message);
        messages.add(message);
    }

    @GetMapping("/get-messages")
    public List<Message> getMessages() {
        return messages;
    }
}