package com.example.retro.controller;

import com.example.retro.exception.GameRentingException;
import com.example.retro.repository.CurrentlyRentingEntity;
import com.example.retro.repository.GameEntity;
import com.example.retro.repository.RentingRepository;
import com.example.retro.service.CurrentlyRenting;
import com.example.retro.service.Game;
import com.example.retro.service.RentingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/games")
public class RentingController {

    private final RentingService rentingService;

    public RentingController(RentingService rentingService) {
        this.rentingService = rentingService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Game>> gameList() {
        List<Game> allGames = rentingService.getAllGames();
        return new ResponseEntity<>(allGames, HttpStatus.OK);
    }

    @GetMapping("/rentable")
    public ResponseEntity<List<Game>> availableGameList() {
        List<Game> availableGames = rentingService.getAvailableGames();
        return new ResponseEntity<>(availableGames, HttpStatus.OK);
    }

    @PostMapping("/rent/{id}")
    public ResponseEntity<?> rentGame(@PathVariable Long id, @RequestBody String email) throws GameRentingException{
        CurrentlyRentingEntity currentlyRentingEntity = rentingService.rentGame(id, email);
        if(currentlyRentingEntity != null) {
            return new ResponseEntity<>("Game successfully rented. ID: " + currentlyRentingEntity.getGameId(), HttpStatus.OK);

        }
            return new ResponseEntity<>("Game cannot be rented. Either not found or already rented.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/rentings")
    public ResponseEntity<List<CurrentlyRenting>> allRentingList() {
        List<CurrentlyRenting> allRentings = rentingService.getAllRenting();
        return new ResponseEntity<>(allRentings, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addGame(@RequestBody Game game) {
        Game savedGame = rentingService.addGame(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }
}
