package com.moha.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{

    @Override
    public String getFortune() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Expect heavy traffics this morning";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if (tripWire){
            throw new RuntimeException("Major accident! Highway is closed!");
        }

        return getFortune();
    }
}
