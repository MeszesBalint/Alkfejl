package com.example.futoverseny_2.service;

import com.example.futoverseny_2.model.Result;
import com.example.futoverseny_2.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    public Result addResult(Result result) {
        return resultRepository.save(result);
    }
}
