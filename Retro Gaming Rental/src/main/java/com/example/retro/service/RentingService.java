package com.example.retro.service;

import com.example.retro.repository.UserRepository;
import com.example.retro.repository.entity.CurrentlyRentingEntity;
import com.example.retro.repository.CurrentlyRentingRepository;
import com.example.retro.repository.entity.GameEntity;
import com.example.retro.repository.RentingRepository;
import com.example.retro.repository.entity.UserEntity;
import com.example.retro.service.model.CurrentlyRenting;
import com.example.retro.service.model.Game;
import com.example.retro.service.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RentingService {
    private final RentingRepository rentingRepository;
    private final CurrentlyRentingRepository currentlyRentingRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public RentingService(RentingRepository rentingRepository, CurrentlyRentingRepository currentlyRentingRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.rentingRepository = rentingRepository;
        this.currentlyRentingRepository = currentlyRentingRepository;
        this.userRepository = userRepository;
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

    public List<User> getAllUserRents() {
        List<UserEntity> allUserEntity = userRepository.findAll();
        List<User> allUser = new ArrayList<>();

        for(UserEntity userEntity : allUserEntity) {
            User user = modelMapper.map(userEntity, User.class);
            allUser.add(user);
        }
        return allUser;
    }


    public Game findGameById(Long id) {
        GameEntity game = rentingRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Game with id " + id + " not found"));
        return modelMapper.map(game, Game.class);
    }

//    public CurrentlyRentingEntity rentGame(Long id, String email) {
//        Optional<GameEntity> optionalGame = rentingRepository.findById(id);
//        Optional<CurrentlyRentingEntity> optionalCurrentRenting = currentlyRentingRepository.findById(id);
//
//
//        if(optionalGame.isPresent() && !optionalCurrentRenting.isPresent()) {
//            GameEntity game = optionalGame.get();
//
//            CurrentlyRentingEntity currentlyRentingEntity = new CurrentlyRentingEntity();
//            currentlyRentingEntity.setGameId(game.getId());
//            currentlyRentingEntity.setEmail(email);
//            currentlyRentingEntity.setName(game.getName());
//            return currentlyRentingRepository.save(currentlyRentingEntity);
//        } else {
//            return null;
//        }
//    }

    public User rentGame(Long id, String email) {
        Optional<GameEntity> optionalGame = rentingRepository.findById(id);
        Optional<CurrentlyRentingEntity> optionalCurrentRenting = currentlyRentingRepository.findById(id);

        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null) {
            userEntity = new UserEntity();
            userEntity.setEmail(email);
            userRepository.save(userEntity);
        }

        if(optionalGame.isPresent() && !optionalCurrentRenting.isPresent()) {
            GameEntity game = optionalGame.get();

            CurrentlyRentingEntity currentlyRentingEntity = new CurrentlyRentingEntity();
            currentlyRentingEntity.setGameId(game.getId());
            currentlyRentingEntity.setEmail(email);
            currentlyRentingEntity.setName(game.getName());

            currentlyRentingRepository.save(currentlyRentingEntity);

            userEntity.addRentingGame(currentlyRentingEntity);
            userRepository.save(userEntity);

            return modelMapper.map(userEntity, User.class);
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
