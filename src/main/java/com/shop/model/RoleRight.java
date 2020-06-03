package com.shop.model;

import org.springframework.data.annotation.Id;

public class RoleRight {
    @Id
    public String id;
    public String roleId;
    public String rightId;

    public RoleRight(String id, String roleId, String rightId) {
        this.id = id;
        this.roleId = roleId;
        this.rightId = rightId;
    }
}