package com.javarush.quest.pogonin.repository.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.quest.pogonin.constants.Constants;
import com.javarush.quest.pogonin.entity.user.User;
import com.javarush.quest.pogonin.repository.user.exceptions.IncorrectPassword;
import com.javarush.quest.pogonin.repository.user.exceptions.UserAlreadyExists;
import com.javarush.quest.pogonin.repository.user.exceptions.UserNotFound;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LocalUserRepository implements UserRepository {

    private List<User> users;


    @Override
    public boolean verifyUser(String login, String password) {
        return false;
    }

    @Override
    public void putUser(User user) throws UserAlreadyExists {
        Path userPatch = Path.of(Constants.USERS_PATCH + user.getName());
        try (FileWriter writer = new FileWriter(userPatch.toFile())) {
            if (Files.exists(userPatch))
                throw new UserAlreadyExists();
                Files.createFile(userPatch);
            Files.write(userPatch, "test".getBytes(StandardCharsets.UTF_8));
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(writer, user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User getUser(String login, String password) throws UserNotFound, IncorrectPassword {

        try (FileReader reader = new FileReader(Constants.USERS_PATCH + login)) {

            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(reader, User.class);
            if (user.getPassword().equals(password))
                return user;
            throw new IncorrectPassword();

        } catch (FileNotFoundException e) {
            throw new UserNotFound();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
