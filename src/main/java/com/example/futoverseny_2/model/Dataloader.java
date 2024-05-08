package com.example.futoverseny_2.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.futoverseny_2.repository.RunnerRepository;
import com.example.futoverseny_2.repository.RaceRepository;
import com.example.futoverseny_2.repository.ResultRepository;

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
        List<Runner> runners = new ArrayList<>();
        runners.add(runner1);
        runners.add(runner2);
        runners.add(runner3);
        runners.add(runner4);
        runnerRepository.saveAll(runners);

        // Betöltjük a tesztadatokat a versenyekhez
        Race race1 = new Race("Maraton", 42195); // Távolság méterben
        Race race2 = new Race("Félmaraton", 21097);
        Race race3 = new Race("Sprint", 400);
        List<Runner> races = new ArrayList<>();
        races.add(runner1);
        runners.add(runner2);
        runners.add(runner3);
        runners.add(runner4);
        raceRepository.saveAll(races);

        // Betöltjük a tesztadatokat az eredményekhez
        Result result1 = new Result(runner1, race1, 180); // John Doe, Marathon, 180 perces időeredmény
        Result result2 = new Result(runner2, race1, 200); // Jane Smith, Marathon, 200 perces időeredmény
        Result result3 = new Result(runner3, race2, 90);  // Bob Johnson, Half Marathon, 90 perces időeredmény
        Result result4 = new Result(runner4, race3, 1); // Alice Brown, Half Marathon, 100 perces időeredmény
        resultRepository.saveAll(List.of(result1, result2, result3, result4));
    }
}