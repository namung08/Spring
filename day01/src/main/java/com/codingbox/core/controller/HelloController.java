package com.codingbox.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //주소에서 /hello 로 매핑이 됨
    public String hello(Model model) {
        model.addAttribute("data","firstData");
        return "forward:/hello";
    }

    /*
    * url : get 방식
    *       /hello-mvc
    * data :    key -> name, value -> name
    * 화면 : hello-template.html(name 데이터 출력)
    * 35 분 까지
    * */
    @GetMapping("/hello-mvc")
    public String hellomvc(Model model) {
        model.addAttribute("name","이상준");
        return "forward:/hello-mvc";
    }

}
