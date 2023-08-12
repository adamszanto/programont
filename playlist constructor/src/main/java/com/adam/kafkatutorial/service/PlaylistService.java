package com.adam.kafkatutorial.service;

import com.adam.kafkatutorial.service.model.PlaylistItem;
import com.adam.kafkatutorial.kafka.payload.UserAction;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class PlaylistService {

    private final List<PlaylistItem> playlist = new CopyOnWriteArrayList<>();
    private final PlaylistChangedKafkaProducer playlistChangedKafkaProducer;

    public PlaylistService(PlaylistChangedKafkaProducer playlistChangedKafkaProducer) {
        this.playlistChangedKafkaProducer = playlistChangedKafkaProducer;
    }

    public void performAction(UserAction action) {
        switch(action.getHeader().getType()) {
            case ADD:
                addPlaylistItem(action.getHeader().getTimestamp(), action.getPayload());
                break;

            case REMOVE:
                removePlaylistItem(action.getPayload());
        }
        playlistChangedKafkaProducer.produce(constructPlayList());
    }

    public void addPlaylistItem(Instant timestamp, String song) {
        playlist.add(new PlaylistItem(timestamp, song));
        Collections.sort(playlist);
    }
    public void removePlaylistItem(String song) {
        Iterator<PlaylistItem> it = playlist.iterator();

        while(it.hasNext()) {
            PlaylistItem current = it.next();
            if(current.getSong().equals(song)) {
                it.remove();
            }
        }
    }

    public List<String> constructPlayList() {
        return playlist.stream().map(
                playlistItem -> playlistItem.getSong()).collect(Collectors.toList());
    }
}
