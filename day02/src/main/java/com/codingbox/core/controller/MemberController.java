package com.codingbox.core.controller;


import com.codingbox.core.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    // Controller가 Service를 의존한다고 표현
    // service는 controller 에서 가져다 쓸 수 있기 위해 spring container 에 등록을 해야 한다.
    // MemberService mService = new MemberService();
    // 스프링 스럽게 작업하기
    // service는 spring container에 하나만 생성 및 등록해서 같이 공유해서 쓸 수 있다.
    private final MemberService memberService;

    /*
    * MemberController 가 생성될 때, 생서자를 호출해준다.
    * 즉 Service까지 생성해서 자동으로 호출해준다.
    * @Autowired를 선언해주면 MemberController 생성하면서 스프링이 memberService와 연결을 해준다.
    * 서버 기동시 연결(의존성) 실패 에러를 발생시켜준다
    *  -> 기존은 테스트를 통해서만 service가 오류난다는 것을 알 수 있다.
    * */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = new MemberService();
    }
}