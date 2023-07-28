package com.example.retro.service;

import com.example.retro.controller.RentingController;
import com.example.retro.repository.GameEntity;
import com.example.retro.repository.RentingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentingService {
    private final RentingRepository rentingRepository;
    private final ModelMapper modelMapper;

    public RentingService(RentingRepository rentingRepository, ModelMapper modelMapper) {
        this.rentingRepository = rentingRepository;
        this.modelMapper = modelMapper;
    }

    public List<Game> getAvailableGames() {
        List<GameEntity> games = rentingRepository.findAllByRentable(true);
        List<Game> gameList = games.stream()
                .map(game -> modelMapper.map(game, Game.class))
                .collect(Collectors.toList());
        return gameList;
    }

    public List<Game> getAllGames() {
        List<GameEntity> gameEntities = rentingRepository.findAll();
        List<Game> gameList = gameEntities.stream()
                .map(game -> modelMapper.map(game, Game.class))
                .collect(Collectors.toList());
        return gameList;
    }

    public Game findGameById(Long id) {
        GameEntity game = rentingRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Game with id " + id + " not found"));
        return modelMapper.map(game, Game.class);
    }

    public boolean rentGame(Long id) {
        Optional<GameEntity> optionalGame = rentingRepository.findById(id);
        if(optionalGame.isPresent()) {
            GameEntity game = optionalGame.get();
            if(game.isRentable()) {
                game.setRentable(false);
                rentingRepository.save(game);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public Game addGame(Game game) {
        GameEntity gameEntity = modelMapper.map(game, GameEntity.class);
        GameEntity savedEntity= rentingRepository.save(gameEntity);
        return modelMapper.map(savedEntity, Game.class);
    }
}
