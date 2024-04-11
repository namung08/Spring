package com.codingbox.shop.controller;

import com.codingbox.shop.domain.table.Address;
import com.codingbox.shop.domain.table.Member;
import com.codingbox.shop.dto.MemberForm;
import com.codingbox.shop.repository.MemberRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    @GetMapping
    public String members() {
        return "member/memberList";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        // validation 처리와 같은 내용 때문에 빈 값이라도 보내준다.
        model.addAttribute("memberForm", new MemberForm());
        return "member/createMemberForm";
    }
    // @Vaild 다음에 BindingResult 있으면, error가 발생시 Binding에 담아준다.
    @PostMapping("/new")
    public String createMember(@Valid MemberForm memberForm, BindingResult result) {
        // 에러가 발생하면 원래 페이지로 돌아가도록 설정
        if (result.hasErrors()) {
            return "member/createMemberForm";
        }

        Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());
        return "redirect:/";
    }

}
