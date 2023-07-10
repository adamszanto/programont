package com.example.restapp.mapper.mapstruct;

import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.repository.entity.PatientEntity;
import com.example.restapp.service.model.Doctor;
import com.example.restapp.service.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructConfig {

    Doctor convertEntityToModel(DoctorEntity doctorEntity);
    DoctorEntity convertModelToEntity(Doctor doctor);
    Patient convertPatientEntityToModel(PatientEntity patientEntity);
    PatientEntity convertPatientModelToEntity(Patient patient);
}
