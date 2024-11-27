package com.moha.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component annotation marks the class as a Spring bean
@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In Constructor: "+getClass().getSimpleName());
    }

    @PostConstruct
    public void doStartupStuff(){
        System.out.println("In doStartupStuff: "+getClass().getSimpleName());
    }

    @PreDestroy
    public void doMycleanupStuff(){
        System.out.println("In doMycleanupStuff: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
