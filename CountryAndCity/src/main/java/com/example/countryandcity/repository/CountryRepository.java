package com.example.countryandcity.repository;

import com.example.countryandcity.repository.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
    CountryEntity findCountryByName(String name);
    CountryEntity findCountryById(Long id);

    @Query("SELECT c FROM CountryEntity c JOIN c.cityEntities city WHERE city.name = :cityName")
    CountryEntity findCountryByCityName(@Param("cityName") String cityName);
}
