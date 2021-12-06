package com.reeves122.microairlines.api.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.reeves122.microairlines.api.model.Player;
import com.reeves122.microairlines.api.repository.PlayerRepository;

@RestController
@RequestMapping("/api/v1/players")
public class PlayersController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping()
    public Collection<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public void createPlayer(){
        playerRepository.save(new Player(BigDecimal.valueOf(100.0)));
    }
}