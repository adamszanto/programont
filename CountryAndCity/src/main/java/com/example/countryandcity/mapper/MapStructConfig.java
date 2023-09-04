package com.example.countryandcity.mapper;

import com.example.countryandcity.repository.entity.CityEntity;
import com.example.countryandcity.repository.entity.CountryEntity;
import com.example.countryandcity.service.model.City;
import com.example.countryandcity.service.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructConfig {
    Country convertEntityToModel(CountryEntity countryEntity);
    CountryEntity convertModelToEntity(Country country);
    City convertCityEntityToModel(CityEntity cityEntity);
    CityEntity convertCityModelToEntity(City city);
}
