package com.example.restapp.controller.dto;

import com.example.restapp.service.model.Patient;

public class PatientDto {
    private Patient patient;

    public PatientDto() {
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }


}
