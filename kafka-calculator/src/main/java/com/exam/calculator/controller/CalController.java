package com.exam.calculator.controller;

import com.exam.calculator.service.CalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CalController {

    @Autowired
    CalService calService;

    @PostMapping(value = "/cal/avg")
    public Object calAvg(@RequestBody Map<String, Object> request) {
        List<Integer> scores = new ArrayList<>();

        scores.add((Integer) request.get("ko"));
        scores.add((Integer) request.get("math"));
        scores.add((Integer) request.get("eng"));

        Map<String, Object> result = new HashMap<>();

        result.put("averageScore", calService.average(scores));

        return result;
    }
}
