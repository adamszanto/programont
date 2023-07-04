package com.example.restapp.mapper;

import com.example.restapp.controller.dto.DoctorDto;
import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.service.model.Doctor;
import org.springframework.stereotype.Component;

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
        doctor.setPatients(doctorEntity.getPatients());

        return doctor;
    }

    public DoctorEntity convertModelToEntity(Doctor doctor) {
        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId(doctor.getId());
        doctorEntity.setName(doctor.getName());
        doctorEntity.setSpecialization(doctor.getSpecialization());
        doctorEntity.setPatients(doctor.getPatients());

        return doctorEntity;
    }
}
