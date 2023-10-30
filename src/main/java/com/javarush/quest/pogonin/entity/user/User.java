package com.javarush.quest.pogonin.entity.user;

import com.javarush.quest.pogonin.entity.AbstractEntity;
import com.javarush.quest.pogonin.entity.Entity;

public class User extends AbstractEntity implements Entity {
    private String name;
    private String password;
    private UserRole role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
