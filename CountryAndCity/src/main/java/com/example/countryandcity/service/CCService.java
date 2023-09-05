package com.example.countryandcity.service;

import com.example.countryandcity.mapper.MapStructImpl;
import com.example.countryandcity.repository.CountryRepository;
import com.example.countryandcity.repository.entity.CityEntity;
import com.example.countryandcity.repository.entity.CountryEntity;
import com.example.countryandcity.service.model.City;
import com.example.countryandcity.service.model.Country;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.example.countryandcity.controller.CCController.CANNOT_FIND_COUNTRY;

@Service
public class CCService {
    private final CountryRepository countryRepository;
    private final MapStructImpl mapStruct;
    public CCService(CountryRepository countryRepository, MapStructImpl mapStruct) {
        this.countryRepository = countryRepository;
        this.mapStruct = mapStruct;
    }

    public Country createCountry(Country country) {
        CountryEntity countryEntity = mapStruct.convertModelToEntity(country);
        CountryEntity savedEntity = countryRepository.save(countryEntity);
        return mapStruct.convertEntityToModel(savedEntity);
    }


    public Country addCity(Long countryId, String cityName) {
        Optional<CountryEntity> optionalCountry = countryRepository.findById(countryId);

        if(optionalCountry.isPresent()) {
            CountryEntity countryEntity = optionalCountry.get();
            CityEntity cityEntity = CityEntity.of(cityName, countryEntity);
            countryEntity.add(cityEntity);
            CountryEntity savedEntity = countryRepository.save(countryEntity);

            return mapStruct.convertEntityToModel(savedEntity);
        } else {
            throw new NoSuchElementException(CANNOT_FIND_COUNTRY + countryId);
        }
    }

    public String findCityById(Long id) {
        Iterable<CountryEntity> countries = countryRepository.findAll();

        for(CountryEntity country : countries) {
            List<CityEntity> cities  = country.getCityEntities();

            for(CityEntity city : cities) {
                if(city.getId().equals(id)) {
                    return city.getName();
                }
            }
        }
        return null;
    }

    public City modifyCity(String cityName, String updatedCityName) {
        Optional<CountryEntity> optionalCountry = Optional.ofNullable(countryRepository.findCountryByName(cityName));

        if(optionalCountry.isPresent()) {
            CountryEntity country = optionalCountry.get();

            for(CityEntity city: country.getCityEntities()) {
                if(city.getName().equals(cityName)) {
                    city.setName(updatedCityName);

                    return mapStruct.convertCityEntityToModel(city);
                }
            }
        }
        return null;
    }

    public List<City> getCitiesByCountryName(String countryName) {
        Iterable<CountryEntity> countries = countryRepository.findAll();

        List<CountryEntity> matchingCountries = StreamSupport.stream(countries.spliterator(), false)
                .filter(country -> country.getName().equalsIgnoreCase(countryName))
                .collect(Collectors.toList());

        if (!matchingCountries.isEmpty()) {
            List<CityEntity> cityEntities = matchingCountries.get(0).getCityEntities();

            List<City> cities = cityEntities.stream()
                    .map(cityEntity -> mapStruct.convertCityEntityToModel(cityEntity))
                    .collect(Collectors.toList());

            return cities;
        }
        return Collections.emptyList();
    }
}
