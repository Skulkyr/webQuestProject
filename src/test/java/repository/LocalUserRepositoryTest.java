package repository;

import com.javarush.quest.pogonin.entity.user.User;
import com.javarush.quest.pogonin.entity.user.UserRole;
import com.javarush.quest.pogonin.repository.user.LocalUserRepository;
import com.javarush.quest.pogonin.repository.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalUserRepositoryTest {

    @Test
    void putUser() {
        UserRepository repository = new LocalUserRepository();
        User user = new User();
        user.setName("Vasia");
        user.setRole(UserRole.USER);
        user.setPassword("123");
        user.setQuestProgress("GeneralQuest", "1-1");
        user.setQuestProgress("GeneralQuest2", "1-3");
        repository.putUser(user);

        User copyUser = repository.getUser("Vasia", "123");
        Assertions.assertEquals(user, copyUser);
    }
}
