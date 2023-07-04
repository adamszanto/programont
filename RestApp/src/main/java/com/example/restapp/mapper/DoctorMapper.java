package com.example.restapp.mapper;

import com.example.restapp.controller.dto.DoctorDto;
import com.example.restapp.repository.entity.DoctorEntity;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {
    public DoctorDto convertEntityToDto(DoctorEntity doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setDoctor(doctor);

        return doctorDto;
    }
}
