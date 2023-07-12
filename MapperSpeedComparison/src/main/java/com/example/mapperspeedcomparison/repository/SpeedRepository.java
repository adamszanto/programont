package com.example.mapperspeedcomparison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeedRepository extends JpaRepository<NodeEntity, Long> {

}
