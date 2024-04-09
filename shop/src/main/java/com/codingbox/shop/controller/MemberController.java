package com.codingbox.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
    @GetMapping
    public String members() {
        return "member/memberList";
    }

    @GetMapping("/new")
    public String createForm() {
        return "member/createMemberForm_";
    }

}
