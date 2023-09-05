package com.example.countryandcity.controller;

import com.example.countryandcity.service.CityService;
import com.example.countryandcity.service.CountryService;
import com.example.countryandcity.service.model.City;
import com.example.countryandcity.service.model.Country;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cc")
public class CCController {
    public final static String CANNOT_FIND_COUNTRY = "Cannot find country with id: ";
    public final static String CANNOT_FIND_CITY = "Cannot find city with id: ";
    private final CountryService countryService;
    private final CityService cityService;

    public CCController(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country savedCountry = countryService.createCountry(country);
        return ResponseEntity.ok(savedCountry);
    }

    @PostMapping("/{id}/city")
    public ResponseEntity<?> createCity(@PathVariable Long id, @RequestBody City city) {
        City newCity = cityService.createCity(id, city);
        if(newCity != null) {
            return ResponseEntity.ok(newCity);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("City is already on the list.");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCountries() {
        List<Country> result = countryService.findAllCountries();

        return ResponseEntity.ok().body(result);
    }
}
