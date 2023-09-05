package com.example.countryandcity.mapper;

import com.example.countryandcity.repository.entity.CountryEntity;
import com.example.countryandcity.service.model.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Mapper
public interface CountryMapper {
    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mapping(source="id", target = "id")
    @Mapping(source="name", target = "name")
    @Mapping(source ="cities", target = "cityEntities")
    CountryEntity countryToCountryEntity(Country country);

    @Mapping(source="id", target = "id")
    @Mapping(source="name", target = "name")
    @Mapping(source ="cityEntities", target = "cities")
    Country countryEntityToCountry(CountryEntity countryEntity);

    @Mapping(source="id", target = "id")
    @Mapping(source="name", target = "name")
    @Mapping(source ="cityEntities", target = "cities")
    List<Country> countryEntityToCountry(List<CountryEntity> countryEntity);
}
