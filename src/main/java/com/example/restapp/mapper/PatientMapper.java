package com.example.restapp.mapper;

import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.repository.entity.PatientEntity;
import com.example.restapp.service.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public PatientEntity convertModelToEntity(DoctorEntity doctor, Patient patient) {
        return PatientEntity.of(patient.getName(), doctor, patient.getBirthDate(), patient.getId());
    }

    public Patient convertEntityToModel(PatientEntity patient) {
        Patient  newPatient = new Patient();
        newPatient.setId(patient.getId());
        newPatient.setBirthDate(patient.getBirthDate());
        newPatient.setName(patient.getName());

        return newPatient;
    }
}
