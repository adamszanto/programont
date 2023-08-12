package com.adam.kafkatutorial.controller;

import com.adam.kafkatutorial.controller.dto.UserInput;
import com.adam.kafkatutorial.service.KafkaConsumerService;
import com.adam.kafkatutorial.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    // TODO: Ahol a user beküldi a dalt először.
    private final KafkaProducerService kafkaProducerService;

    public MessageController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public void postToPlayList(@RequestBody UserInput userInput) {
        kafkaProducerService.produce(userInput);

    }
}
