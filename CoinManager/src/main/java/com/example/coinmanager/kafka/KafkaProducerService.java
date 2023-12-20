package com.example.coinmanager.service;

import com.example.coinmanager.service.model.CurrencyPriceData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final String kafkaTopic;

    private final KafkaTemplate<String, CurrencyPriceData> kafkaTemplate;

    public KafkaProducerService(@Value("${playlister.kafka.producer.topic}") String kafkaTopic, KafkaTemplate<String, CurrencyPriceData> kafkaTemplate) {
        this.kafkaTopic = kafkaTopic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(CurrencyPriceData data) {
        Message<CurrencyPriceData> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "BTCcoinDataProducerTopic")
                .build();
        kafkaTemplate.send(message);
    }
}
