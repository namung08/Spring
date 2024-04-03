package com.codingbox.mylogin.domain.login;

import com.codingbox.mylogin.domain.login.session.SessionConst;
import com.codingbox.mylogin.domain.member.Member;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) {
        return "login/loginForm";
    }
    /*
    model : 데이터를 전달 할 때 forward 방식으로 전달이 됨
    redirectAttributes : redirect 방식을 전달
    * */
//    @PostMapping("/login")
    public String loginV2(@ModelAttribute("loginForm") LoginForm loginForm, Model model,
                        RedirectAttributes redirectAttributes, HttpServletResponse response) {
        Member member = loginService.login(loginForm);
        if(member == null) {
            model.addAttribute("msg","false");
            return "login/loginForm";
        } else {
            // redirectAttributes.addAttribute
            //  : url뒤에 붙으며, 리프레시 해도 데이터가 유지된다
            // redirectAttributes.addFlashAttribute
            //  : url뒤에 붙지 않는다. 일회성이라 리프레시할 경우 데이터가 소멸
//            redirectAttributes.addFlashAttribute("msg","true");
            Cookie cookie = new Cookie("memberId",String.valueOf(member.getId()));
            response.addCookie(cookie);
            return "redirect:/";
        }
    }

//    @PostMapping("/login")
    public String  loginV3(@ModelAttribute("loginForm") LoginForm loginForm, Model model, RedirectAttributes redirectAttributes, HttpServletRequest req) {
        Member member = loginService.login(loginForm);
        if(member == null) {
            model.addAttribute("msg","false");
            return "login/loginForm";
        }
        HttpSession session = req.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);
        return "redirect:/";
    }
    @PostMapping("/login")
    public String  loginV4(@ModelAttribute("loginForm") LoginForm loginForm, Model model, RedirectAttributes redirectAttributes, HttpServletRequest req,
                           @RequestParam(name = "redirectURL",required = false,defaultValue = "/") String redirect) {
        Member member = loginService.login(loginForm);
        if(member == null) {
            model.addAttribute("msg","false");
            return "login/loginForm";
        }
        System.out.println("redirectURL : "+redirect);
        HttpSession session = req.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);
        return "redirect:"+redirect;
    }
//    @PostMapping("/Logout")
    public String logoutV2(HttpServletResponse resp) {
        Cookie cookie = new Cookie("memberId", null);
        // 쿠키의 유지시간
        // 쿠키 즉시 종료
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        return "redirect:/";
    }
    @PostMapping("/Logout")
    public String logoutV3(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if(session != null) {
            // session에 있는 데이터를 전부 삭제 하는 명령어
            session.invalidate();
        }
        return "redirect:/";
    }
}
