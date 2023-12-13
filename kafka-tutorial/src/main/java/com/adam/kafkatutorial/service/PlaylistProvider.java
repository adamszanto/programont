package com.adam.kafkatutorial.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PlaylistProvider {
    private final List<String> fetchCurrentList = new CopyOnWriteArrayList<>();

    @KafkaListener(topics = "playlistActionTopic", groupId = "Group-Id-01")
    public void updatePlaylist(List<String> playlist) {
        fetchCurrentList.clear();
        fetchCurrentList.addAll(playlist);
    }

    public List<String> retrievePlaylist() {
        // TODO: MEgirni a flow metódust
        return fetchCurrentList;
    }
}
