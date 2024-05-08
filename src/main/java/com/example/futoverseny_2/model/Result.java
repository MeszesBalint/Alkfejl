package com.example.futoverseny_2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Runner runner;

    @ManyToOne
    private Race race;

    private int timeInMinutes;

    public Result() {

    }

    public Result(Runner runner, Race race, int timeInMinutes) {
        this.runner = runner;
        this.race = race;
        this.timeInMinutes = timeInMinutes;
    }

    public Runner getRunner() {
        return runner;
    }

    public Race getRace() {
        return race;
    }

    public int getTimeInMinutes() {
        return timeInMinutes;
    }

}