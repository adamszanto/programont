package com.example.restapp.service;

import com.example.restapp.mapper.DoctorMapper;
import com.example.restapp.repository.DoctorRepository;
import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.repository.entity.PatientEntity;
import com.example.restapp.service.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }

    public DoctorEntity findDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Doctor with id " + id + " not found"));
    }

    public Doctor addPatient(Long id, String patientName) {
        Optional<DoctorEntity> optionalDoctor = doctorRepository.findById(id);

        // TODO: Custom Exception, átmappelni státuszkóddá
        if (optionalDoctor.isEmpty()) {
            throw new NoSuchElementException("No doctor with given ID");
        }

        DoctorEntity doctorEntity = optionalDoctor.get();
        doctorEntity.add(PatientEntity.of(patientName, doctorEntity));
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

    public DoctorEntity updateDoctorSpecialization(Long id, String specialization) {
        DoctorEntity doctor = findDoctorById(id);
        doctor.setSpecialization(specialization);

        return doctorRepository.save(doctor);
    }

    public Doctor createDoctor(Doctor doctor) {
        DoctorEntity doctorEntity = doctorMapper.convertModelToEntity(doctor);
        DoctorEntity savedEntity = doctorRepository.save(doctorEntity);
        return doctorMapper.convertEntityToModel(savedEntity);
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
}
