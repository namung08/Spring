package com.codingbox.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {
    // 필수 값에 대한 처리를 java에서 처리
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
