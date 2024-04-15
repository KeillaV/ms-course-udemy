package com.udemy.hroauth.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Data
public class User implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
