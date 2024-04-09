package com.codingbox.mylogin.intercepter;

import com.codingbox.mylogin.domain.login.session.SessionConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckIntercepter  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String reqURI = request.getRequestURI();
        System.out.println("[인증 체크 인터셉터 실행] : " + reqURI);
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null) {
            System.out.println("[미인증 사용자 요청]");
            // 로그인으로 redirect
            response.sendRedirect("/login?redirectURL="+reqURI);
            return false;
        }
        return true;
    }
}
