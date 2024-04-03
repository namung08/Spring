package com.codingbox.mylogin.domain.login;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class LoginForm {
    private String loginId;
    private String password;
}
