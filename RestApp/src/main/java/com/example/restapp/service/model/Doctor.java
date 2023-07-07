package com.example.restapp.service.model;

import java.util.List;
import java.util.Objects;

public class Doctor {
    private Long id;
    private String name;
    private String specialization;
    private List<Patient> patients;

    public Doctor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (!Objects.equals(id, doctor.id)) return false;
        if (!Objects.equals(name, doctor.name)) return false;
        if (!Objects.equals(specialization, doctor.specialization))
            return false;
        return Objects.equals(patients, doctor.patients);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        result = 31 * result + (patients != null ? patients.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", patients=" + patients +
                '}';
    }
}
