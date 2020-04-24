package com.soaic.hellospringboot.entity;

import java.io.Serializable;

public class Role implements Serializable {

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
