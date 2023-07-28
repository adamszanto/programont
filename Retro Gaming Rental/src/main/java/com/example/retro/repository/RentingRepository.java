package com.example.retro.repository;

import com.example.retro.repository.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentingRepository extends JpaRepository<GameEntity, Long> {
    List<GameEntity> findByReleasedPlatform(String releasedPlatform);
}
