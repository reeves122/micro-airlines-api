package com.reeves122.microairlines.api.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.reeves122.microairlines.api.model.City;
import com.reeves122.microairlines.api.repository.CityRepository;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class CitiesController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public Collection<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        Optional<City> city = cityRepository.findById(id);
        return city.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/cities")
    public void createCity(){
        cityRepository.save(new City("New York", "United States"));
    }

}