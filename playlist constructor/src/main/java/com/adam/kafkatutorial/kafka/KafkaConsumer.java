package com.adam.kafkatutorial.kafka;

import com.adam.kafkatutorial.kafka.payload.UserAction;
import com.adam.kafkatutorial.service.PlaylistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private final PlaylistService playlistService;

    public KafkaConsumer(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @KafkaListener(topics = "${playlister.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(UserAction userAction) {
        LOGGER.info(String.format("Song received: %s", userAction.getPayload()));
        playlistService.performAction(userAction);
    }
}
