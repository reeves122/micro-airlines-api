package com.reeves122.microairlines.api.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.reeves122.microairlines.api.model.City;
import com.reeves122.microairlines.api.model.Player;
import com.reeves122.microairlines.api.repository.CityRepository;
import com.reeves122.microairlines.api.repository.PlayerRepository;

@RestController
@RequestMapping("/api/v1/cities")
public class CitiesController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping()
    public Collection<City> getAllCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        Optional<City> city = cityRepository.findById(id);
        return city.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public void createCity(@RequestParam(name="player_id") Long playerId){
        Player player = playerRepository.findById(playerId).orElse(null);

        City city = new City("New York", "United States");
        city.setPlayer(player);
        cityRepository.save(city);
    }

}