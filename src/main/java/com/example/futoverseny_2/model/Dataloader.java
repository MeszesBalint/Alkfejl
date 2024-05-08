package com.example.futoverseny_2.model;

import com.example.futoverseny_2.repository.RaceRepository;
import com.example.futoverseny_2.repository.ResultRepository;
import com.example.futoverseny_2.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Dataloader implements CommandLineRunner {

    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;
    private final ResultRepository resultRepository;

    @Autowired
    public Dataloader(RunnerRepository runnerRepository, RaceRepository raceRepository, ResultRepository resultRepository) {
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
        this.resultRepository = resultRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Betöltjük a tesztadatokat a futókhoz
        Runner runner1 = new Runner("John Doe", 30, "male");
        Runner runner2 = new Runner("Jane Smith", 25, "female");
        Runner runner3 = new Runner("Bob Johnson", 40, "male");
        Runner runner4 = new Runner("Alice Brown", 35, "female");
        runnerRepository.saveAll(List.of(runner1, runner2, runner3, runner4));

        // Betöltjük a tesztadatokat a versenyekhez
        List<Race> races = new ArrayList<>();
        races.add(new Race("Maraton", 42195)); // Távolság méterben
        races.add(new Race("Félmaraton", 21097));
        races.add(new Race("Sprint", 400));
        raceRepository.saveAll(races);

        // Betöltjük a tesztadatokat az eredményekhez
        Result result1 = new Result(runner1, races.get(0), 180); // John Doe, Marathon, 180 perces időeredmény
        Result result2 = new Result(runner2, races.get(0), 200); // Jane Smith, Marathon, 200 perces időeredmény
        Result result3 = new Result(runner3, races.get(1), 90);  // Bob Johnson, Half Marathon, 90 perces időeredmény
        Result result4 = new Result(runner4, races.get(2), 100); // Alice Brown, Half Marathon, 100 perces időeredmény
        resultRepository.saveAll(List.of(result1, result2, result3, result4));
    }
}
