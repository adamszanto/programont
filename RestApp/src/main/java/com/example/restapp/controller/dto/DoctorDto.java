package com.example.restapp.controller.dto;

import com.example.restapp.service.model.Doctor;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Objects;

@XmlRootElement
public class DoctorDto {
    private Doctor doctor;

    public DoctorDto() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorDto doctorDto = (DoctorDto) o;

        return Objects.equals(doctor, doctorDto.doctor);
    }

    @Override
    public int hashCode() {
        return doctor != null ? doctor.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                "doctor=" + doctor +
                '}';
    }
}
