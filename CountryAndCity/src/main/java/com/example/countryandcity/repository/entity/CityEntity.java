package com.example.countryandcity.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cities")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    @JoinColumn(name = "countries_id", nullable = false)
    private CountryEntity country;

    public static CityEntity of(String cityName, CountryEntity country) {
        return CityEntity.of(cityName, country, null);
    }

    public static CityEntity of(String cityName, CountryEntity country, Long id) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setName(cityName);
        cityEntity.setCountry(country);
        cityEntity.setId(id);

        return cityEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}
