package com.example.futoverseny_2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int distance;

    public Race() {
        // Az alapértelmezett konstruktor hozzáadása
    }

    public Race(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    // getters and setters


}