package com.example.restapp.repository;

import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Long> {
    List<DoctorEntity> findByName(String name);
    @Query("SELECT s FROM DoctorEntity s WHERE s.name = :name")
    List<Doctor> selectByName(@Param("name") String name);
}
