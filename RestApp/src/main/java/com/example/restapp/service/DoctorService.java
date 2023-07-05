package com.example.restapp.service;

import com.example.restapp.mapper.DoctorMapper;
import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.repository.DoctorRepository;
import com.example.restapp.repository.entity.PatientEntity;
import com.example.restapp.service.model.Doctor;
import com.example.restapp.service.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, DoctorMapper doctorMapper, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
        this.modelMapper = modelMapper;
    }

    public DoctorEntity findDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Doctor with id " + id + " not found"));
    }

    public Doctor addPatient(Long id, String patientName) {
        Optional<DoctorEntity> optionalDoctor = doctorRepository.findById(id);

        DoctorEntity doctorEntity = optionalDoctor.get();


        Patient patient = new Patient();
        patient.setName(patientName);
        PatientEntity patientEntity = new PatientEntity();
        modelMapper.map(patient, patientEntity);

        doctorEntity.getPatients().add(patientEntity);
        DoctorEntity savedEntity = doctorRepository.save(doctorEntity);
        //return doctorMapper.convertEntityToModel(savedEntity);

        return modelMapper.map(savedEntity, Doctor.class);
    }

    public List<DoctorEntity> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public DoctorEntity updateDoctorSpecialization(Long id, String specialization) {
        DoctorEntity doctor = findDoctorById(id);
        doctor.setSpecialization(specialization);

        return doctorRepository.save(doctor);
    }

//    public Doctor createDoctor(Doctor doctor) {
//        DoctorEntity doctorEntity = new DoctorEntity();
//        doctorEntity.setName(doctor.getName());
//        doctorEntity.setPatients(doctorEntity.getPatients());
//        doctorEntity.setSpecialization(doctor.getSpecialization());
//
//        DoctorEntity savedEntity = doctorRepository.save(doctorEntity);
//        return doctorMapper.convertEntityToModel(savedEntity);
//    }

    public Doctor createDoctor(Doctor doctor) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setName(doctor.getName());
        doctorEntity.setPatients(doctorEntity.getPatients());
        doctorEntity.setSpecialization(doctor.getSpecialization());

        DoctorEntity savedEntity = doctorRepository.save(doctorEntity);
        return modelMapper.map(savedEntity, Doctor.class);
    }

    public void deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
    }
}
