
// ResultController.java

package com.example.futoverseny_2.controller;

import com.example.futoverseny_2.model.Result;
import com.example.futoverseny_2.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("getAllResults")
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @PostMapping("addResult")
    public ResponseEntity<?> addResult(@Valid @RequestBody Result result, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>("Invalid data provided", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resultService.addResult(result), HttpStatus.CREATED);
    }
}
