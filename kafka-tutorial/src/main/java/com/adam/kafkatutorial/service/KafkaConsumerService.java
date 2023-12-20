package com.adam.kafkatutorial.service;

import com.adam.kafkatutorial.controller.dto.UserInput;
import com.adam.kafkatutorial.kafka.payload.UserAction;
import com.adam.kafkatutorial.repository.KafkaDataRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final String kafkaTopic;
    private final KafkaDataRepository kafkaDataRepository;
    private final KafkaTemplate<String, UserAction> kafkaTemplate;

    public KafkaConsumerService(@Value("${playlister.kafka.consumer.topic}") String kafkaTopic, KafkaDataRepository kafkaDataRepository, KafkaTemplate<String, UserAction> kafkaTemplate) {
        this.kafkaTopic = kafkaTopic;
        this.kafkaDataRepository = kafkaDataRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void consume(UserInput userInput) {
        kafkaDataRepository.save(userInput);
    }

}
