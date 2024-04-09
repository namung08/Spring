package com.codingbox.jpaitem.embeded;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Embeddable
@Getter @Setter
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    // 테스트를 위해 파라미터4가 있는 생성자 만들기

    public Period(LocalDateTime startDate, LocalDateTime endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Period() {
    }
}
