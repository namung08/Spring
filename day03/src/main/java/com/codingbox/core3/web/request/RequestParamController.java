package com.codingbox.core3.web.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class RequestParamController {
    // 반환 타입에 없으면서 응답값을 직접 일력하면, view를 조회하지 않는다.
    // void 타입이면서 response에 값을 쓰면, 쓴 값이 화면에 보이게 된다.
    @RequestMapping("/request-param-v1")
    public void requestparamV1(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("usernaem : " + username);
        System.out.println("age : " + age);
        resp.getWriter().write("ok");
    }

}
