package com.codingbox.core.dto;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @SequenceGenerator(name = "seq",sequenceName = "member_seq",allocationSize = 1)
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
