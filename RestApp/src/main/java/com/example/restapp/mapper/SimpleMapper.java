package com.example.restapp.mapper;

import com.example.restapp.controller.dto.DoctorDto;
import com.example.restapp.repository.entity.DoctorEntity;
import com.example.restapp.service.model.Doctor;
import org.mapstruct.Mapper;

@Mapper
public interface SimpleMapper {
    Doctor doctorDtoToModel(DoctorDto doctorDto);
    DoctorDto modelToDoctorDto(Doctor doctor);
    DoctorEntity modelToDoctorEntity(Doctor doctor);
    Doctor entityToModel(DoctorEntity doctorEntity);
}
