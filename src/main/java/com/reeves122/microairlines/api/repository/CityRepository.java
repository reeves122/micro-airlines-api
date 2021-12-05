package com.reeves122.microairlines.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reeves122.microairlines.api.model.City;

public interface CityRepository extends JpaRepository<City, Long> {}