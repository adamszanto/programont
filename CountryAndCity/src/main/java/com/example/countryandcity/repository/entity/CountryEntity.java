package com.example.countryandcity.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "countries")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CityEntity> cityEntities;

    public void add(CityEntity city) {
        if(cityEntities == null) {
            cityEntities = new ArrayList<>();
        }
        cityEntities.add(city);
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

    public List<CityEntity> getCityEntities() {
        return cityEntities;
    }

    public void setCityEntities(List<CityEntity> cityEntities) {
        this.cityEntities = cityEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cityEntities, that.cityEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cityEntities);
    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityEntities=" + cityEntities +
                '}';
    }
}
