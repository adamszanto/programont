package com.example.coinmanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic coinDataTopic(@Value("${coin.manager.kafka.topic}") String kafkaTopic) {
        return TopicBuilder.name(kafkaTopic)
                .build();
    }
}
