package com.example.restapp.controller.dto;

import com.example.restapp.service.model.Patient;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientDto that = (PatientDto) o;

        return Objects.equals(patient, that.patient);
    }

    @Override
    public int hashCode() {
        return patient != null ? patient.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "patient=" + patient +
                '}';
    }
}
