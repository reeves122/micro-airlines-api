package com.reeves122.microairlines.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue
    @Column(name = "city_id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @OneToMany(mappedBy = "city")
    private List<Job> jobs;

    @ManyToOne
    @JoinColumn(name="player_id")
    @JsonBackReference
    private Player player;

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }
}