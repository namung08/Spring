package com.codingbox.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /*
    url : /
    return : home.html
    * */
    @GetMapping
    public String home() {
        return "home";
    }
}
