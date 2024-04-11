package com.codingbox.shop.test;

public enum Type {
    HIKING("등산화"), RUNNING("러닝화"), TRACKING("트래킹화"), WALKING("워킹화");

    final private String name;
    // enum 에서 생성자 같은 역할
    private Type(String name) {
        this.name = name;
    }
    // 문자를 받아오는 함수
    public String getName() {
        return name;
    }
}
