package com.exam.calculator.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalService {

    public Double average(List<Integer> scores) {
        Double avg;
        Integer sum = 0;

        for (Integer score : scores) {
            sum += score;
        }

        avg = Double.valueOf(sum / scores.size());

        return avg;
    }
}
