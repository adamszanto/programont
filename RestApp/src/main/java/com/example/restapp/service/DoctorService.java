package com.example.restapp.service;

import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorEntity findDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Doctor with id " + id + " not found"));
    }

    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public DoctorEntity updateDoctorSpecialization(Long id, String specialization) {
        DoctorEntity doctor = findDoctorById(id);
        doctor.setSpecialization(specialization);
        // Esetleg további műveletek, validáció, adatbázis mentés stb.
        return doctorRepository.save(doctor);
    }

    public DoctorEntity saveDoctor(DoctorEntity doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
}
