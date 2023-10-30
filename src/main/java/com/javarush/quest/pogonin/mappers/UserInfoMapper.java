package com.javarush.quest.pogonin.mappers;

import com.javarush.quest.pogonin.dto.user.UserInfoDto;
import com.javarush.quest.pogonin.entity.Entity;
import com.javarush.quest.pogonin.entity.user.User;

public class UserInfoMapper extends AbstractMapper implements Mapper {
    @Override
    public UserInfoDto getDto(Entity entity) {
        checkCorrectEntity(entity, User.class);
        User user = (User) entity;
        UserInfoDto dto = new UserInfoDto();

        dto.setName(user.getName());
        dto.setRole(user.getRole());

        return dto;
    }
}
