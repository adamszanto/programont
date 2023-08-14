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

    public MessageController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping
    public void postToPlayList(@RequestBody UserInput userInput) {
        kafkaProducerService.produce(userInput);
    }
}
