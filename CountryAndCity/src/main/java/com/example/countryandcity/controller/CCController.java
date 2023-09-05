package com.example.countryandcity.controller;

import com.example.countryandcity.service.CCService;
import com.example.countryandcity.service.model.City;
import com.example.countryandcity.service.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cc")
public class CCController {
    public final static String CANNOT_FIND_COUNTRY = "Cannot find country with id: ";
    public final static String CANNOT_FIND_CITY = "Cannot find city with id: ";
    private final CCService ccService;

    public CCController(CCService ccService) {
        this.ccService = ccService;
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country savedCountry = ccService.createCountry(country);
        return ResponseEntity.ok(savedCountry);
    }

    @PostMapping("/{id}/city")
    public ResponseEntity<?> addCity(@PathVariable Long id, @RequestBody City city) {
        try {
            Country updatedCountry = ccService.addCity(id, city.getName());
            return ResponseEntity.ok(updatedCountry);
        } catch (Exception e) {
            String errorMessage = CANNOT_FIND_COUNTRY + id;
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @PatchMapping("/city/{cityName}")
    public ResponseEntity<?> updateCity(@PathVariable String cityName, @RequestBody String updatedCityName) {
        City result = ccService.modifyCity(cityName, updatedCityName);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{country}/cities")
    public List<City> getCitiesByCountryName(@PathVariable String country) {
        return ccService.getCitiesByCountryName(country);
    }
}
