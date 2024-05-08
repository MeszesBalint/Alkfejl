
// RunnerController.java

package com.example.futoverseny.controller;

import com.example.futoverseny_2.model.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.futoverseny_2.service.RunnerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/runners")
public class RunnerController {

    private final RunnerService runnerService;

    @Autowired
    public RunnerController(RunnerService runnerService) {
        this.runnerService = runnerService;
    }

    @GetMapping("getAllRunners")
    public List<Runner> getAllRunners() {
        return runnerService.getAllRunners();
    }

    @PostMapping("addRunner")
    public ResponseEntity<?> addRunner(@Valid @RequestBody Runner runner, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Invalid data provided", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(runnerService.addRunner(runner), HttpStatus.CREATED);
    }
}
