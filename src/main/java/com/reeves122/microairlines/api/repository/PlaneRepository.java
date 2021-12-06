package com.reeves122.microairlines.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reeves122.microairlines.api.model.Plane;

public interface PlaneRepository extends JpaRepository<Plane, Long> {}