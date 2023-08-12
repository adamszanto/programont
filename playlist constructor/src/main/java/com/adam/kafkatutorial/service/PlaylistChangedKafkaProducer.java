package com.adam.kafkatutorial.service;

import com.adam.kafkatutorial.kafka.KafkaProducer;
import com.adam.kafkatutorial.kafka.payload.Action;
import com.adam.kafkatutorial.kafka.payload.PlaylistChanged;
import com.adam.kafkatutorial.kafka.payload.UserAction;
import com.adam.kafkatutorial.kafka.payload.EventHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class PlaylistChangedKafkaProducer {

    private final KafkaProducer kafkaProducer;
    private final String producerId;
    public PlaylistChangedKafkaProducer(KafkaProducer kafkaProducer,@Value("${playlister.kafka.producer.id}") String producerId) {
        this.kafkaProducer = kafkaProducer;
        this.producerId = producerId;
    }

    public void produce(List<String> playlist) {
        PlaylistChanged playlistChanged = new PlaylistChanged();
        EventHeader header = new EventHeader();
        header.setMessageId(UUID.randomUUID().toString());
        header.setTimestamp(Instant.now());
        header.setType(Action.CHANGED);
        header.setOwnerId(producerId);

        playlistChanged.setHeader(header);
        playlistChanged.setPayload(playlist);
        kafkaProducer.produce(playlistChanged);
    }
}
