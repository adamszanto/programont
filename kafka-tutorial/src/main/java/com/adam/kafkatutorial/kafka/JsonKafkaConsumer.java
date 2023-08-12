package com.adam.kafkatutorial.kafka;

import com.adam.kafkatutorial.controller.dto.UserInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "myJsonTopic", groupId = "myGroup")
    public void consume(UserInput userInput) {
        LOGGER.info(String.format("Json message received: %s", userInput.toString()));
    }
}
