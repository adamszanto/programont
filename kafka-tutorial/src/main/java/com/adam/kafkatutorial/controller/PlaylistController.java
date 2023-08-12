package com.adam.kafkatutorial.controller;

import com.adam.kafkatutorial.service.PlaylistProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/kafka")
public class PlaylistController {
    // TODO: Visszaadni a playlistet (Kafkából frissül a háttérben)
    private final PlaylistProvider playlistProvider;

    public PlaylistController(PlaylistProvider playlistProvider) {
        this.playlistProvider = playlistProvider;
    }

    @GetMapping
    public ResponseEntity<List<String>>  currentPlayList() {
        return ResponseEntity.ok(playlistProvider.retrievePlaylist());
    }
}
