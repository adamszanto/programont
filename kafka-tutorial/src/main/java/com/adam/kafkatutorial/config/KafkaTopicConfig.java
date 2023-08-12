package com.adam.kafkatutorial.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic playlistChangedTopic(@Value("${playlister.kafka.consumer.topic}") String kafkaTopic) {
        return TopicBuilder.name(kafkaTopic)
                .build();
    }

    @Bean
    public NewTopic performActionOnPlaylist(@Value("${playlister.kafka.producer.topic}") String kafkaTopic) {
        return TopicBuilder.name(kafkaTopic)
                .build();
    }
}
