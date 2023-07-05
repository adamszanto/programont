package com.example.restapp.mapper;

import com.example.restapp.controller.dto.DoctorDto;
import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.repository.entity.PatientEntity;
import com.example.restapp.service.model.Doctor;
import com.example.restapp.service.model.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper {
    public DoctorDto convertModelToDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setDoctor(doctor);

        return doctorDto;
    }

    public Doctor convertEntityToModel(DoctorEntity doctorEntity) {
        Doctor doctor = new Doctor();

        doctor.setName(doctorEntity.getName());
        doctor.setId(doctorEntity.getId());
        doctor.setSpecialization(doctorEntity.getSpecialization());

        List<Patient> patients = new ArrayList<>();
        doctorEntity.getPatients().forEach(patientName -> {
            Patient patient = new Patient();
            patient.setName(patientName.getName());
            patients.add(patient);
        });
        doctor.setPatients(patients);
        return doctor;
    }

    public DoctorEntity convertModelToEntity(Doctor doctor) {
        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId(doctor.getId());
        doctorEntity.setName(doctor.getName());
        doctorEntity.setSpecialization(doctor.getSpecialization());

        List<PatientEntity> patientEntities = new ArrayList<>();
        doctor.getPatients().forEach(patient -> {
            PatientEntity patientEntity = new PatientEntity();
            patientEntity.setName(patient.getName());
            patientEntities.add(patientEntity);
        });
        doctorEntity.setPatients(patientEntities);
        return doctorEntity;
    }

}
