package com.codingbox.mylogin.domain.login;

import com.codingbox.mylogin.domain.member.Member;
import com.codingbox.mylogin.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(LoginForm loginForm) {
        String loginid = loginForm.getLoginId();
        String password = loginForm.getPassword();
        Member member = memberRepository.findByLoginId(loginid);
        if (member != null && member.getLoginId().equals(loginid) && member.getPassword().equals(password)) {
            return member;
        }
        return null;
    }

}
