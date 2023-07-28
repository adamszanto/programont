package com.example.retro.repository;

import com.example.retro.repository.entity.CurrentlyRentingEntity;
import com.example.retro.repository.entity.GameEntity;
import com.example.retro.repository.entity.UserEntity;
import com.example.retro.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
