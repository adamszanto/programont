package com.adam.kafkatutorial.kafka;

import com.adam.kafkatutorial.kafka.payload.PlaylistChanged;
import com.adam.kafkatutorial.kafka.payload.UserAction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final String kafkaTopic;
    private final KafkaTemplate<String, PlaylistChanged> kafkaTemplate;

    public KafkaProducer(@Value("${playlister.kafka.producer.topic}")String kafkaTopic, KafkaTemplate<String, PlaylistChanged> kafkaTemplate) {
        this.kafkaTopic = kafkaTopic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(PlaylistChanged playlistChanged) {
        Message<PlaylistChanged> message = MessageBuilder
                .withPayload(playlistChanged)
                .setHeader(KafkaHeaders.TOPIC, kafkaTopic)
                .build();

        kafkaTemplate.send(message);
    }
}
