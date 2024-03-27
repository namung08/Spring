package com.codingbox.core.controller;


import com.codingbox.core.dto.Member;
import com.codingbox.core.dto.MemberFormDTO;
import com.codingbox.core.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    // controller가 service를 의존한다고 표현
    // Service는 여러 Controller에서 가져다 쓸 수 있기위해
    // Spring container에 등록을 해야 한다
    // MemberService mService = new MemberService();

    // 스프링 스럽게 작업하기
    // service는 Spring Container에 하나만 생성 및 등록해서 같이 공유해서 쓸 수 있다.
    private final MemberService memberService;
    /*
    멤버 컨트롤러가 생성될때
    생성자를 호출해준다
    즉 Service까지 생성해서 자동으로 호출해준다
    @Autowired를 선언해주면 MemberController 생성하면서
    스프링이 memberSercvice와 연결을 해준다.
    서버 기동시 연결 실패 에러를 발생시켜준다
    -> 기존은 테스트를 통해서만 service가 오류난다는 것을 알 수 있다.
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // url -> members/new
    // 화면 return /members/createMemberForm.html
    @GetMapping(value = "/members/new")
    public String createForm() {
        return "/members/createMemberForm";
    }
    @PostMapping(value = "/members/new")
    public String create(MemberFormDTO formDTO) {
        Member member = new Member();
        member.setName(formDTO.getName());
        memberService.join(member);
        // 홈 화면으로 이동
        // forward 방식이 아닌 redirect 방식으로 이동해야함
        return "redirect:/";
    }
    // url : members
    // return  members/memberList
    @GetMapping("members")
    public String listMember(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}

