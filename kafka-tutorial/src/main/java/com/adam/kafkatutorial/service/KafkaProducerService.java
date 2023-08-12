package com.adam.kafkatutorial.service;

import com.adam.kafkatutorial.controller.dto.UserInput;
import com.adam.kafkatutorial.kafka.payload.UserAction;
import com.adam.kafkatutorial.kafka.payload.UserActionHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class KafkaProducerService {

    private final String kafkaTopic;

    private final KafkaTemplate<String, UserAction> kafkaTemplate;

    public KafkaProducerService(@Value("${playlister.kafka.producer.topic}") String kafkaTopic, KafkaTemplate<String, UserAction> kafkaTemplate) {
        this.kafkaTopic = kafkaTopic;
        this.kafkaTemplate = kafkaTemplate;
    }


    public void produce(UserInput userInput) {
        UserActionHeader header = new UserActionHeader();
        header.setMessageId(UUID.randomUUID().toString());
        header.setTimestamp(Instant.now());
        header.setType(userInput.getAction());
        header.setOwnerId(userInput.getOwner());

        UserAction userAction = new UserAction();
        userAction.setHeader(header);
        userAction.setPayload(userInput.getData());

        Message<UserAction> message = MessageBuilder
                .withPayload(userAction)
                .setHeader(KafkaHeaders.TOPIC, kafkaTopic)
                .build();

        kafkaTemplate.send(message);
    }
}
