package com.vote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller                     // is listening CRUD
public class DashboardController {

    // listening for the get request on "/" URL
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String rootView(){       // most of the method return String
        return "index";             // is going to return the view "index" - resources folder
    }
}
