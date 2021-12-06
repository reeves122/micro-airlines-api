package com.reeves122.microairlines.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Plane {

    @Id
    @GeneratedValue
    @Column(name = "plane_id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "plane")
    private List<Job> jobs;

    @ManyToOne
    @JoinColumn(name="player_id")
    private Player player;
}
