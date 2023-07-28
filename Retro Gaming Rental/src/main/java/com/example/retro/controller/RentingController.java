package com.example.retro.controller;

import com.example.retro.exception.GameRentingException;
import com.example.retro.repository.entity.CurrentlyRentingEntity;
import com.example.retro.service.model.CurrentlyRenting;
import com.example.retro.service.model.Game;
import com.example.retro.service.RentingService;
import com.example.retro.service.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getGameById(@PathVariable Long id) {
        try {
            Game game = rentingService.findGameById(id);
            if(game == null) {
                throw new GameRentingException(GameRentingException.CANNOT_RENT + id);
            }
            return ResponseEntity.ok(game);
        } catch (GameRentingException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    @GetMapping("/rentable")
    public ResponseEntity<List<Game>> availableGameList() {
        List<Game> availableGames = rentingService.getAvailableGames();
        return new ResponseEntity<>(availableGames, HttpStatus.OK);
    }

//    @PostMapping("/rent/{id}")
//    public ResponseEntity<?> rentGame(@PathVariable Long id, @RequestBody String email) throws GameRentingException{
//        CurrentlyRentingEntity currentlyRentingEntity = rentingService.rentGame(id, email);
//        if(currentlyRentingEntity != null) {
//            return new ResponseEntity<>("Game successfully rented. ID: " + currentlyRentingEntity.getGameId(), HttpStatus.OK);
//
//        }
//            return new ResponseEntity<>("Game cannot be rented. Either not found or already rented.", HttpStatus.BAD_REQUEST);
//    }

    @PostMapping("/rent/{id}")
    public ResponseEntity<?> rentGame(@PathVariable Long id, @RequestBody String email) throws GameRentingException{
        User user = rentingService.rentGame(id, email);
        if(user != null) {
            return new ResponseEntity<>("Game successfully rented by: " + email, HttpStatus.OK);
        }
        return new ResponseEntity<>("Game cannot be rented. Either not found or already rented.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/rentings")
    public ResponseEntity<List<CurrentlyRenting>> allRentingList() {
        List<CurrentlyRenting> allRentings = rentingService.getAllRenting();
        return new ResponseEntity<>(allRentings, HttpStatus.OK);
    }

    @GetMapping("/userrentings")
    public ResponseEntity<List<User>> allUserRentingList() {
        List<User> allUserRentings = rentingService.getAllUserRents();
        return new ResponseEntity<>(allUserRentings, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addGame(@RequestBody Game game) {
        Game savedGame = rentingService.addGame(game);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);
    }
}
