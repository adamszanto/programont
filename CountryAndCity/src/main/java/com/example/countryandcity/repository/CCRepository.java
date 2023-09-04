package com.example.countryandcity.repository;

import com.example.countryandcity.repository.entity.CountryEntity;
import com.example.countryandcity.service.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CCRepository extends JpaRepository<CountryEntity, Long> {
    CountryEntity findCountryByName(String name);
    public CountryEntity findCountryById(Long id);
}
