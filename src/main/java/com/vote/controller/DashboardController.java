package com.vote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                     // is listening CRUD
public class DashboardController {

    // listening for the get request on "/" URL
    @GetMapping("/")                // instead of @RequestMapping(value = "/", method = RequestMethod.GET)
    public String rootView() {       // most of the method return String
        return "index";             // is going to return the view "index" - resources folder
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
