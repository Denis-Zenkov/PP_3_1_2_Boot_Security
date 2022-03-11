package ru.kata.spring.boot_security.demo.model;

public enum Permission {
    USERS_USER("users:read"),
    USERS_ADMIN("users:write");

    private final String permission;

    Permission(String permission){
        this.permission=permission;
    }
    public String getPermission(){
        return permission;
    }
}
