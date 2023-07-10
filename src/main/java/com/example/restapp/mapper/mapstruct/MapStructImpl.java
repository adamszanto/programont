package com.example.restapp.mapper.mapstruct;

import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.repository.entity.PatientEntity;
import com.example.restapp.service.model.Doctor;
import com.example.restapp.service.model.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapStructImpl implements MapStructConfig {

    @Override
    public Doctor convertEntityToModel(DoctorEntity doctorEntity) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorEntity.getId());
        doctor.setName(doctorEntity.getName());
        doctor.setSpecialization(doctorEntity.getSpecialization());
        List<Patient> patients = doctorEntity.getPatients().stream()
                        .map(patientEntity -> convertPatientEntityToModel(patientEntity))
                        .collect(Collectors.toList());

        doctor.setPatients(patients);
        return doctor;
    }

    @Override
    public DoctorEntity convertModelToEntity(Doctor doctor) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setId(doctor.getId());
        doctorEntity.setName(doctor.getName());
        doctorEntity.setSpecialization(doctor.getSpecialization());

        List<PatientEntity> patientEntities = doctor.getPatients().stream()
                .map(patient -> convertPatientModelToEntity(patient))
                .collect(Collectors.toList());

        doctorEntity.setPatients(patientEntities);
        return doctorEntity;
    }

    @Override
    public Patient convertPatientEntityToModel(PatientEntity patientEntity) {
        Patient patient = new Patient();
        patient.setId(patientEntity.getId());
        patient.setName(patientEntity.getName());
        patient.setBirthDate(patientEntity.getBirthDate());

        return patient;
    }

    @Override
    public PatientEntity convertPatientModelToEntity(Patient patient) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patient.getId());
        patientEntity.setName(patient.getName());
        patientEntity.setBirthDate(patient.getBirthDate());

        return patientEntity;
    }
}
