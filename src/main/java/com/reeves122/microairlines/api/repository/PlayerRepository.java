package com.reeves122.microairlines.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reeves122.microairlines.api.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {}