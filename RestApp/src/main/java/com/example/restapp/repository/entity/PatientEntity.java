package com.example.restapp.repository.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    public static PatientEntity of(String name, DoctorEntity doctor) {

        return PatientEntity.of(name, doctor, null);
    }

    public static PatientEntity of(String name, DoctorEntity doctor, Long id) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setName(name);
        patientEntity.setDoctor(doctor);
        patientEntity.setId(id);
        return patientEntity;
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

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientEntity that = (PatientEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
