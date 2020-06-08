package com.shop.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    public String id;
    public String firstName;
    public String lastName;
    public String city;
    public String userName;
    public String password;
    public String roleId;
    public Role role;

    public User(String id, String firstName, String lastName, String city, String userName, String password,
            String roleId, Role role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.userName = userName;
        this.password = password;
        this.roleId = roleId;
        this.role = role;
    }
}