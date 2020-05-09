package com.ukim.finki.wp.chessshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //RestController posle
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String indexPage(){
        return "home";
    }

    @GetMapping("/home")
    public String homePage(){
        return "home";
    }
}
