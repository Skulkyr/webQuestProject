package mapper;

import com.javarush.quest.pogonin.dto.user.UserInfoDto;
import com.javarush.quest.pogonin.entity.user.User;
import com.javarush.quest.pogonin.entity.user.UserRole;
import com.javarush.quest.pogonin.mappers.factory.DtoType;
import com.javarush.quest.pogonin.mappers.factory.MapperFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UserInfoMapperTest {
    @Test
    void MappingTest() {
        User user = new User();
        user.setName("Vasia");
        user.setRole(UserRole.USER);

        UserInfoDto dto = MapperFactory.getMapper(DtoType.USER_INFO).getDto(user);

        Assertions.assertEquals(user.getName(), dto.getName());
        Assertions.assertEquals(user.getRole(), dto.getRole());
    }
}
