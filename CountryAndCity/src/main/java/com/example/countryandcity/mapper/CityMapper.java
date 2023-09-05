package com.example.countryandcity.mapper;

import com.example.countryandcity.repository.entity.CityEntity;
import com.example.countryandcity.service.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CityEntity cityToCityEntity(City city);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    City cityEntityToCity(CityEntity city);
}
