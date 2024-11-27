package com.moha.springcoredemo.rest;

import com.moha.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private final Coach myCoach;
    private final Coach anotherCoach;

    // define a constructor for dependency injection
    @Autowired
    public DemoController(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In Constructor: "+getClass().getSimpleName());
        myCoach= theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    // All beans are Singleton unless you change that using scope
    @GetMapping("/check")
    public String check(){
        // when we set scope as SCOPE_PROTOTYPE for CricketCoach then this will return false
        return "Comparing beans: myCoach and anotherCoach, "+(myCoach==anotherCoach);
    }
}
