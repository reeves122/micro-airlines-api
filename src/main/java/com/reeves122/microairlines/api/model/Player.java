package com.reeves122.microairlines.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue
    @Column(name = "player_id")
    private Long id;

    @Column(name="balance")
    private BigDecimal balance;

    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<City> cities;

    @OneToMany(mappedBy = "player")
    @JsonManagedReference
    private List<Plane> plane;

    public Player(BigDecimal balance) {
        this.balance = balance;
    }
}
