package com.example.countryandcity.service;

import com.example.countryandcity.mapper.CityMapper;
import com.example.countryandcity.repository.CityRepository;
import com.example.countryandcity.repository.CountryRepository;
import com.example.countryandcity.repository.entity.CityEntity;
import com.example.countryandcity.repository.entity.CountryEntity;
import com.example.countryandcity.service.model.City;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    public CityService(CountryRepository countryRepository, CityRepository cityRepository) {
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }


    public City createCity(Long id, City city) {
        CityEntity cityEntity = CityMapper.INSTANCE.cityToCityEntity(city);

        Optional<CountryEntity> countryEntity = Optional.ofNullable(countryRepository.findCountryById(id));

        CountryEntity result = countryEntity.get();
        cityEntity.setCountry(result);
        CityEntity savedEntity = cityRepository.save(cityEntity);

        return CityMapper.INSTANCE.cityEntityToCity(savedEntity);

    }
}
