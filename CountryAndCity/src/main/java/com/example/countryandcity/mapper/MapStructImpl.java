package com.example.countryandcity.mapper;

import com.example.countryandcity.repository.entity.CityEntity;
import com.example.countryandcity.repository.entity.CountryEntity;
import com.example.countryandcity.service.model.City;
import com.example.countryandcity.service.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapStructImpl implements MapStructConfig{

    @Override
    public Country convertEntityToModel(CountryEntity countryEntity) {
        Country country = new Country();
        country.setId(countryEntity.getId());
        country.setName(countryEntity.getName());
        List<City> cities = countryEntity.getCityEntities().stream()
                .map(cityEntity -> convertCityEntityToModel(cityEntity))
                .collect(Collectors.toList());

        country.setCities(cities);
        return country;
    }

    @Override
    public CountryEntity convertModelToEntity(Country country) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(country.getId());
        countryEntity.setName(country.getName());
        List<CityEntity> cityEntities = country.getCities().stream()
                .map(city -> convertCityModelToEntity(city))
                .collect(Collectors.toList());
        countryEntity.setCityEntities(cityEntities);
        return countryEntity;
    }

    @Override
    public City convertCityEntityToModel(CityEntity cityEntity) {
        City city = new City();
        city.setId(cityEntity.getId());
        city.setName(cityEntity.getName());

        return city;
    }

    @Override
    public CityEntity convertCityModelToEntity(City city) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId(city.getId());
        cityEntity.setName(city.getName());

        return cityEntity;
    }
}
