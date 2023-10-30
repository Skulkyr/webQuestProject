package com.javarush.quest.pogonin.dto.user;

import com.javarush.quest.pogonin.dto.Dto;
import com.javarush.quest.pogonin.entity.user.UserRole;

public class UserInfoDto implements Dto {
    private String name;
    private String gameCount;
    private String ipAddress;
    private UserRole role;

    public UserInfoDto() {
    }

    public String getName() {
        return name;
    }

    public String getGameCount() {
        return gameCount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public UserRole getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGameCount(String gameCount) {
        this.gameCount = gameCount;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
