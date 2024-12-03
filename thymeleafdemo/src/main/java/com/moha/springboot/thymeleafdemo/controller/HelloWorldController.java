package com.moha.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a new controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a new controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDuds(HttpServletRequest request, Model theModel){
        String studentName = request.getParameter("studentName");
        String result = "Yo! "+ studentName.toUpperCase();
        theModel.addAttribute("message", result);
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String studentName, Model theModel){
        String result = "Hey my friend from V3! "+ studentName.toUpperCase();
        theModel.addAttribute("message", result);
        return "helloworld";
    }
}
