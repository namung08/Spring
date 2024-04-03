package com.codingbox.mylogin.web;

import com.codingbox.mylogin.domain.login.session.SessionConst;
import com.codingbox.mylogin.domain.member.Member;
import com.codingbox.mylogin.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberRepository memberRepository;
//    @GetMapping
    public String homePage() {
        return "home";
    }
    // 로그인 처리까지 되는 home화면을 확인
    // required = false 로그인 안한 사용자도 들어와야 한다.
//    @GetMapping
    public String homelogin(@CookieValue(name="memberId", required = false)Long memberId, Model model) {
        // 로그인한 사용자가 아니라면 home 화면으로 보냄
        if(memberId == null) {
            return "home";
        }
        // db조회를 한 후에 사용자가 없으면 null 처리
        Member member = memberRepository.findById(memberId);
        if(member == null){
            return "home";
        }
        // loginHome : 로그인에 성공한 사람만이 볼 수 있는 화면
        model.addAttribute("member",member);
        return "login/loginHome";
    }

//    @GetMapping
    public String homeLoginV3(HttpServletRequest req, Model model) {
        HttpSession session = req.getSession(false);

        if (session == null) {
            return "home";
        }
        Member member = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(member == null){
            return "home";
        }

        model.addAttribute("member",member);
        return "login/loginHome";
    }
    @GetMapping
    public String homeLoginV4(@SessionAttribute(name=SessionConst.LOGIN_MEMBER, required = false) Member member,
                              Model model) {
        if(member == null) {
            return "home";
        }
        model.addAttribute("member",member);
        return "login/loginHome";
    }
}
