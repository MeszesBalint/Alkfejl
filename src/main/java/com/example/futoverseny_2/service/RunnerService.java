package com.example.futoverseny_2.service;

import com.example.futoverseny_2.model.Runner;
import com.example.futoverseny_2.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RunnerService {

    private final RunnerRepository runnerRepository;

    @Autowired
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public List<Runner> getAllRunners() {
        return runnerRepository.findAll();
    }

    public Runner addRunner(Runner runner) {
        return runnerRepository.save(runner);
    }
}