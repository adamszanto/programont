package com.example.countryandcity.service;

import com.example.countryandcity.mapper.MapStructImpl;
import com.example.countryandcity.repository.CCRepository;
import com.example.countryandcity.repository.entity.CountryEntity;
import com.example.countryandcity.service.model.Country;
import org.springframework.stereotype.Service;

@Service
public class CCService {
    private final CCRepository ccRepository;
    private final MapStructImpl mapStruct;
    public CCService(CCRepository ccRepository, MapStructImpl mapStruct) {
        this.ccRepository = ccRepository;
        this.mapStruct = mapStruct;
    }

    public Country createCountry(Country country) {
        CountryEntity countryEntity = mapStruct.convertModelToEntity(country);
        CountryEntity savedEntity = ccRepository.save(countryEntity);
        return mapStruct.convertEntityToModel(savedEntity);
    }
}
