package com.codingbox.mylogin.filter;

import com.codingbox.mylogin.domain.login.session.SessionConst;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;
import java.util.logging.LogRecord;

public class LoginCheckFilter implements Filter {
    // 필터 생성
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    // 필터 삭제
    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private static final String[] whitelist = {"/","/members/add","/login","/logout","/css/*"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        System.out.println("인증 체크 필터 시작 : " + requestURI);
        if(isLoginCheckPath(requestURI)) {
            // filter를 태울 예정
            System.out.println("인증 체크 로직 실행"+requestURI);
            // 화이트 리스트에 없는 주소가 찍힘
            HttpSession session = httpServletRequest.getSession(false);
            if (session == null || session.getAttribute(SessionConst.LOGIN_MEMBER) == null ) {
                System.out.println("미인증 사용자의 요청 : "+ requestURI);
                httpServletResponse.sendRedirect("/login?redirectURL="+requestURI);
                return;
            }
        }
        chain.doFilter(request,response);
    }
// 화이트 리스트의 경우 인증체크 하지 않는다.
    private boolean isLoginCheckPath(String requestURI) {
        return !PatternMatchUtils.simpleMatch(whitelist,requestURI);
    }
}
