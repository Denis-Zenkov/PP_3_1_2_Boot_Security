package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private String role;

    public Role() {
    }

    public Role(String name) {
        this.role = name;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}
