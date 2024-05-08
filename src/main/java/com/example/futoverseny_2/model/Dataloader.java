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
        Runner runner1 = new Runner("Ádám", 30, "férfi");
        Runner runner2 = new Runner("Béla", 25, "férfi");
        Runner runner3 = new Runner("Zsófi", 40, "nő");
        Runner runner4 = new Runner("Emese", 35, "nő");
        runnerRepository.saveAll(List.of(runner1, runner2, runner3, runner4));

        List<Race> races = new ArrayList<>();
        races.add(new Race("Maraton", 42195));
        races.add(new Race("Félmaraton", 21097));
        races.add(new Race("Sprint", 400));
        raceRepository.saveAll(races);

        Result result1 = new Result(runner1, races.get(0), 180);
        Result result2 = new Result(runner2, races.get(0), 200);
        Result result3 = new Result(runner3, races.get(1), 90);
        Result result4 = new Result(runner4, races.get(2), 100);
        resultRepository.saveAll(List.of(result1, result2, result3, result4));
    }
}
