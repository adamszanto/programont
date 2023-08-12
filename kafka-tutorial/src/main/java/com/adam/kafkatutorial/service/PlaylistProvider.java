package com.adam.kafkatutorial.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class PlaylistProvider {
    // TODO: updatePlaylist, retrievePlaylist metódus...
    private final List<String> fetchCurrentList = new CopyOnWriteArrayList<>();


    public void updatePlaylist(List<String> playlist) {
        fetchCurrentList.clear();
        fetchCurrentList.addAll(playlist);
    }

    public List<String> retrievePlaylist() {
        return fetchCurrentList;
    }
}
