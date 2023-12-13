package com.adam.kafkatutorial.repository;

import com.adam.kafkatutorial.controller.dto.UserInput;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaDataRepository extends MongoRepository<UserInput, String> {
}