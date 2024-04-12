package com.codingbox.shop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class HomeController {
    /*
    URL: /
    return: home.html
     */
    @RequestMapping("/")
    public String home() {
        log.info("home Controller!!");
        return "home";
    }

}
