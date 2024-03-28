package com.codingbox.core3.web.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /* @ResponseBody
    *  - view 조회를 무시하고, http message body에 직접 해당 내용 입력
    * -------------------------------------------------------------------
    * @RequestParam
    * - 파라미터 이름으로 바인딩*/
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestparamV2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge){
        System.out.println("usernaem : " + memberName);
        System.out.println("age : " + memberAge);
        return "ok";
    }
    /*@RequestParam 사용
    * HTTP 파라미터 이름이 변수 이름과 같으면
    * @RequestParam(name="...")생략가능*/
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestparamV3(@RequestParam String username, @RequestParam int age){
        System.out.println("username : " + username);
        System.out.println("age : " + age);
        return "ok";
    }

}
