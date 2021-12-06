package com.reeves122.microairlines.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue
    @Column(name = "job_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name="plane_id")
    private Plane plane;
}
