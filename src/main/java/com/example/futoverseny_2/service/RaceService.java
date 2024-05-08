// RaceService.java

package com.example.futoverseny_2.service;

import com.example.futoverseny_2.model.Race;
import com.example.futoverseny_2.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces() {
        return raceRepository.findAll();
    }

    public Race addRace(Race race) {
        return raceRepository.save(race);
    }
}