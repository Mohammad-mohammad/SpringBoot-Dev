package com.moha.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BassballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }
}
