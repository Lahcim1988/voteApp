package com.vote.controller;

import com.vote.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")   // instead of  @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(ModelMap model){
        model.put("user", new User());                // key - user 15min 19vid
        return "register";
    }

    // recommended in POST method to use redirect
    @PostMapping("/register")                   // it's belong to User cause we create new User
    public String registerPost(User user){      // not needed(maybe because thymeleaf) @ModelAttribute binding - mean taking the data from html file and binding it to User Object
        System.out.println(user);
        return "redirect:/register";            // should return redirect - prevent from sending the data twice (eg. refresh)
    }
 }
