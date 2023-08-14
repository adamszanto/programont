package com.adam.kafkatutorial.kafka;

import com.adam.kafkatutorial.controller.dto.UserInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private final KafkaTemplate<String, UserInput> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, UserInput> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(UserInput data) {
        LOGGER.info(String.format("Message sent: %s", data.toString()));
        Message<UserInput> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "playlistActionTopic")
                .build();

        kafkaTemplate.send(message);
    }
}
