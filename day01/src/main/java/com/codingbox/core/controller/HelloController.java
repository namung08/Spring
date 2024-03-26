package com.codingbox.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //주소에서 /hello 로 매핑이 됨
    public String hello(Model model) {
        model.addAttribute("data","firstData");
        return "hello";
    }

}
