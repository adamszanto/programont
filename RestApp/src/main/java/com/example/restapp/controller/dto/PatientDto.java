package com.example.restapp.controller.dto;

import com.example.restapp.service.model.Patient;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
