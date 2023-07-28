package com.example.retro.service;

import com.example.retro.repository.CurrentlyRentingEntity;
import com.example.retro.repository.CurrentlyRentingRepository;
import com.example.retro.repository.GameEntity;
import com.example.retro.repository.RentingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RentingService {
    private final RentingRepository rentingRepository;
    private final CurrentlyRentingRepository currentlyRentingRepository;
    private final ModelMapper modelMapper;

    public RentingService(RentingRepository rentingRepository, CurrentlyRentingRepository currentlyRentingRepository, ModelMapper modelMapper) {
        this.rentingRepository = rentingRepository;
        this.currentlyRentingRepository = currentlyRentingRepository;
        this.modelMapper = modelMapper;
    }

    public List<Game> getAvailableGames() {
        List<GameEntity> allGames = rentingRepository.findAll();
        List<Long> rentedGameIds = currentlyRentingRepository.findAll()
                .stream()
                .map(CurrentlyRentingEntity::getGameId)
                .collect(Collectors.toList());

        List<Long> availableGameIds = allGames.stream()
                .map(GameEntity::getId)
                .filter(gameId -> !rentedGameIds.contains(gameId))
                .collect(Collectors.toList());

        return allGames.stream()
                .filter(game -> availableGameIds.contains(game.getId()))
                .map(game -> modelMapper.map(game, Game.class))
                .collect(Collectors.toList());

//        return availableGameIds.stream()
//                .map(gameId -> rentingRepository.findById(gameId))
//                .filter(Optional::isPresent)
//                .map(Optional::get)
//                .map(game -> modelMapper.map(game, Game.class))
//                .collect(Collectors.toList());
    }

    public List<Game> getAllGames() {
        List<GameEntity> allGames = rentingRepository.findAll();
        return allGames.stream()
                .map(game -> modelMapper.map(game, Game.class))
                .collect(Collectors.toList());
    }

    public List<CurrentlyRenting> getAllRenting() {
        List<CurrentlyRentingEntity> allRenting = currentlyRentingRepository.findAll();
        return allRenting.stream()
                .map(renting -> modelMapper.map(renting, CurrentlyRenting.class))
                .collect(Collectors.toList());
    }


    public Game findGameById(Long id) {
        GameEntity game = rentingRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Game with id " + id + " not found"));
        return modelMapper.map(game, Game.class);
    }

    public CurrentlyRentingEntity rentGame(Long id, String email) {
        Optional<GameEntity> optionalGame = rentingRepository.findById(id);
        Optional<CurrentlyRentingEntity> optionalCurrentRenting = currentlyRentingRepository.findById(id);

        if(optionalGame.isPresent() && !optionalCurrentRenting.isPresent()) {
            GameEntity game = optionalGame.get();

            CurrentlyRentingEntity currentlyRentingEntity = new CurrentlyRentingEntity();
            currentlyRentingEntity.setGameId(game.getId());
            currentlyRentingEntity.setEmail(email);
            return currentlyRentingRepository.save(currentlyRentingEntity);
        } else {
            return null;
        }
    }

    public Game addGame(Game game) {
        GameEntity gameEntity = modelMapper.map(game, GameEntity.class);
        GameEntity savedEntity= rentingRepository.save(gameEntity);
        return modelMapper.map(savedEntity, Game.class);
    }
}
