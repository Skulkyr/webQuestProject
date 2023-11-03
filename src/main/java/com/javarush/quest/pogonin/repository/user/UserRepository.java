package com.javarush.quest.pogonin.repository.user;

import com.javarush.quest.pogonin.entity.user.User;
import com.javarush.quest.pogonin.repository.user.exceptions.IncorrectPassword;
import com.javarush.quest.pogonin.repository.user.exceptions.UserAlreadyExists;
import com.javarush.quest.pogonin.repository.user.exceptions.UserNotFound;

public interface UserRepository {
    public boolean verifyUser(String login, String password);

    public void putUser(User user) throws UserAlreadyExists;

    public User getUser(String login, String password) throws UserNotFound, IncorrectPassword;
}
