package com.example.restapp.service;

import com.example.restapp.mapper.DoctorMapper;
import com.example.restapp.repository.CustomRepository;
import com.example.restapp.repository.DoctorRepository;
import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.repository.entity.PatientEntity;
import com.example.restapp.service.model.Doctor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private final CustomRepository customRepository;

    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper, CustomRepository customRepository) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
        this.customRepository = customRepository;
    }

    public Doctor findDoctorById(Long id) {
        DoctorEntity doctor = doctorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Doctor with id " + id + " not found"));
        return doctorMapper.convertEntityToModel(doctor);
    }

    // EntityManager method:
    public Doctor customFindDoctorById(Long id) {
        DoctorEntity doctorEntity = customRepository.findById(id);
        return doctorMapper.convertEntityToModel(doctorEntity);
    }

    public Doctor nativeFindDoctorById(Long id) {
        DoctorEntity doctorEntity = customRepository.nativeFindById(id);
        return doctorMapper.convertEntityToModel(doctorEntity);
    }

    public void nativeDeleteAll() {
        customRepository.nativeDeleteAll();
    }

    public Doctor addPatient(Long id, String patientName, Date birthDate) {
        Optional<DoctorEntity> optionalDoctor = doctorRepository.findById(id);

        if (optionalDoctor.isEmpty()) {
            throw new NoSuchElementException("No doctor with given ID");
        }

        DoctorEntity doctorEntity = optionalDoctor.get();
        doctorEntity.add(PatientEntity.of(patientName, doctorEntity, birthDate));
        DoctorEntity savedEntity = doctorRepository.save(doctorEntity);
        return doctorMapper.convertEntityToModel(savedEntity);

    }

    public List<Doctor> getAllDoctors() {
        List<DoctorEntity> doctors = doctorRepository.findAll();
        List<Doctor> doctorList = doctors.stream()
                .map(doctor -> doctorMapper.convertEntityToModel(doctor))
                .collect(Collectors.toList());
        return doctorList;
    }

    public Doctor updateDoctorSpecialization(Long id, String specialization) {
        Doctor doctor = findDoctorById(id);
        doctor.setSpecialization(specialization);

        DoctorEntity doctorEntity = doctorMapper.convertModelToEntity(doctor);
        doctorRepository.save(doctorEntity);

        return doctorMapper.convertEntityToModel(doctorEntity);
    }

    public Doctor createDoctor(Doctor doctor) {
        DoctorEntity doctorEntity = doctorMapper.convertModelToEntity(doctor);
        DoctorEntity savedEntity = doctorRepository.save(doctorEntity);
        return doctorMapper.convertEntityToModel(savedEntity);
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }

    public void deleteAllDoctor() {
        customRepository.deleteAll();
    }

    public Long getDoctorCount() {
        return customRepository.count();
    }

}
