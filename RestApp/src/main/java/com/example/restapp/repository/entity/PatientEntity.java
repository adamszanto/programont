package com.example.restapp.repository.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorEntity doctor;

    public static PatientEntity of(String name, DoctorEntity doctor, Date birthDate) {

        return PatientEntity.of(name, doctor, birthDate,  null);
    }

    public static PatientEntity of(String name, DoctorEntity doctor, Date birthDate, Long id) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setName(name);
        patientEntity.setDoctor(doctor);
        patientEntity.setId(id);
        patientEntity.setBirthDate(birthDate);
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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
