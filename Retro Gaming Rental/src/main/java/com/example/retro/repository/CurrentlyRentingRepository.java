package com.example.retro.repository;

import com.example.retro.repository.entity.CurrentlyRentingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrentlyRentingRepository extends JpaRepository<CurrentlyRentingEntity, Long> {
    List<CurrentlyRentingEntity> findAllByEmail(String email);
}
