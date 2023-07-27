package com.example.retro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/games")
public class RentingController {
    private List<Game> games = new ArrayList<>();

    public RentingController() {
        initializeGames();
    }

    private void initializeGames() {
        Game game1 = new Game("Donkey Kong Country", 1994, Platform.SNES, "https://images.igdb.com/igdb/image/upload/t_cover_big/co6pym.png", true);
        Game game2 = new Game("Gran Turismo 2", 1999, Platform.PLAYSTATION, "https://images.igdb.com/igdb/image/upload/t_cover_big/co20af.png", true);

        games.add(game1);
        games.add(game2);
    }

    @GetMapping
    public ResponseEntity<List<Game>> gameList() {
        List<Game> availableGames = new ArrayList<>();
        for (Game game : games) {
            if (game.isRentable()) {
                availableGames.add(game);
            }
        }
        return new ResponseEntity<>(availableGames, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addGame(@RequestBody Game game) {
        games.add(game);

        return new ResponseEntity<>("Game added successfully: " +  game.toString(), HttpStatus.OK);
    }
}
