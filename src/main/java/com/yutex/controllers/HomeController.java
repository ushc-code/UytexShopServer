package com.yutex.controllers;

import com.yutex.model.entities.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model){
        if(user != null){
            model.addAttribute("user",user.getUsername());
            return "index";
        }

        model.addAttribute("user","anonymous");
        return "index";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("/forUser")
    public String forUser(){
        return "foruser";
    }
    @GetMapping("/forAdmin")
    public String forAdmin(){
        return "foradmin";
    }
}
