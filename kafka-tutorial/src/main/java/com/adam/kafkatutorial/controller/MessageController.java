package com.adam.kafkatutorial.controller;

import com.adam.kafkatutorial.controller.dto.UserInput;
import com.adam.kafkatutorial.service.KafkaConsumerService;
import com.adam.kafkatutorial.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    private final KafkaProducerService kafkaProducerService;
    private final KafkaConsumerService kafkaConsumerService;

    public MessageController(KafkaProducerService kafkaProducerService, KafkaConsumerService kafkaConsumerService) {
        this.kafkaProducerService = kafkaProducerService;
        this.kafkaConsumerService = kafkaConsumerService;
    }

    @PostMapping
    public void postToPlayList(@RequestBody UserInput userInput) {
        kafkaProducerService.produce(userInput);
        kafkaConsumerService.consume(userInput);
    }
}
