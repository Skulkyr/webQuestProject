package com.javarush.quest.pogonin.repository.user;

import com.javarush.quest.pogonin.entity.user.User;

public interface UserRepository {
    public boolean verifyUser(String login, String password);

    public void putUser(User user);

    public User getUser(String login, String password);
}
