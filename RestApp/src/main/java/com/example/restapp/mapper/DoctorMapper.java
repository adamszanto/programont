package com.example.restapp.mapper;

import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.repository.entity.PatientEntity;
import com.example.restapp.service.model.Doctor;
import com.example.restapp.service.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DoctorMapper {

    private final PatientMapper patientMapper;

    public DoctorMapper(PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
    }


    public Doctor convertEntityToModel(DoctorEntity doctorEntity) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorEntity.getName());
        doctor.setId(doctorEntity.getId());
        doctor.setSpecialization(doctorEntity.getSpecialization());

        if(doctorEntity.getPatients() != null) {
            doctor.setPatients(mapFrom(doctorEntity.getPatients()));
        }
        return doctor;
    }

    private List<Patient> mapFrom(List<PatientEntity> patients) {
        return patients.stream()
                .map(patient -> patientMapper.convertEntityToModel(patient))
                .collect(Collectors.toList());
    }

    public DoctorEntity convertModelToEntity(Doctor doctor) {
        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId(doctor.getId());
        doctorEntity.setName(doctor.getName());
        doctorEntity.setSpecialization(doctor.getSpecialization());
        if(doctor.getPatients() != null) {
            doctorEntity.setPatients(mapFrom(doctor.getPatients(), doctorEntity));
        }
        return doctorEntity;
    }

    private List<PatientEntity> mapFrom(List<Patient> patients, DoctorEntity doctor) {
        return patients.stream()
                .map(patient -> patientMapper.convertModelToEntity(doctor, patient))
                .collect(Collectors.toList());
    }
}