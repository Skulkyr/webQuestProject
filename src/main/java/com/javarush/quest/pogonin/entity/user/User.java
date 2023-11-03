package com.javarush.quest.pogonin.entity.user;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.javarush.quest.pogonin.entity.AbstractEntity;
import com.javarush.quest.pogonin.entity.Entity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends AbstractEntity implements Entity {
    private String name;
    private String password;
    private UserRole role;
    @JsonSerialize
    private Map<String, String> questProgress;

    public User() {
        questProgress = new HashMap<>();
    }

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

    public void setQuestProgress(String quests, String level) {
        questProgress.put(quests, level);
    }

    public String getQuestProgress(String quest) {
        return questProgress.get(quest);
    }



    @JsonAnySetter
    public void setQuestProgress(Map<String, String> questProgress) {
        this.questProgress = questProgress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder().append(name, user.name).append(password, user.password).append(role, user.role).append(questProgress, user.questProgress).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name).append(password).append(role).append(questProgress).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("password", password)
                .append("role", role)
                .append("questProgress", questProgress)
                .toString();
    }
}
