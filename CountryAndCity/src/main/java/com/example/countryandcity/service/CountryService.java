package com.example.countryandcity.service;

import com.example.countryandcity.mapper.CityMapper;
import com.example.countryandcity.mapper.CountryMapper;
import com.example.countryandcity.repository.CountryRepository;
import com.example.countryandcity.repository.entity.CityEntity;
import com.example.countryandcity.repository.entity.CountryEntity;
import com.example.countryandcity.service.model.City;
import com.example.countryandcity.service.model.Country;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country createCountry(Country country) {
        CountryEntity countryEntity = CountryMapper.INSTANCE.countryToCountryEntity(country);
        CountryEntity savedEntity = countryRepository.save(countryEntity);
        return CountryMapper.INSTANCE.countryEntityToCountry(savedEntity);
    }


    public List<Country> findAllCountries() {
        List<CountryEntity> result = countryRepository.findAll();

        return CountryMapper.INSTANCE.countryEntityToCountry(result);
    }

    public Country findCountryById(Long id) {
        Optional<CountryEntity> result = Optional.ofNullable(countryRepository.findCountryById(id));

        CountryEntity foundCountry = result.get();

        return CountryMapper.INSTANCE.countryEntityToCountry(foundCountry);
    }



//    public List<City> getCitiesByCountryName(String countryName) {
//        Iterable<CountryEntity> countries = countryRepository.findAll();
//
//        List<CountryEntity> matchingCountries = StreamSupport.stream(countries.spliterator(), false)
//                .filter(country -> country.getName().equalsIgnoreCase(countryName))
//                .collect(Collectors.toList());
//
//        if (!matchingCountries.isEmpty()) {
//            List<CityEntity> cityEntities = matchingCountries.get(0).getCityEntities();
//
//            List<City> cities = cityEntities.stream()
//                    .map(cityEntity -> CityMapper.INSTANCE.cityEntityToCity(cityEntity))
//                    .collect(Collectors.toList());
//
//            return cities;
//        }
//        return Collections.emptyList();
//    }
}
