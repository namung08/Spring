package com.codingbox.shop.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {
    // 필수 값에 대한 처리를 java에서 처리
    // error 발생시 message 안에 있는 내용을 name 값에 담아 return 한다.
    @NotEmpty(message = "회원 이름은 필수 값 입니다.")
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
