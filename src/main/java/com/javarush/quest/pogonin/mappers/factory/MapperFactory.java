package com.javarush.quest.pogonin.mappers.factory;

import com.javarush.quest.pogonin.mappers.Mapper;
import com.javarush.quest.pogonin.mappers.UserInfoMapper;

public class MapperFactory {
    public static Mapper getMapper(DtoType type) {
        return switch (type) {
            case USER_INFO -> new UserInfoMapper();
        };
    }
}
