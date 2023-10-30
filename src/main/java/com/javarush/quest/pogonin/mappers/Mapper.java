package com.javarush.quest.pogonin.mappers;

import com.javarush.quest.pogonin.dto.Dto;
import com.javarush.quest.pogonin.entity.Entity;

public interface Mapper {
    <T extends Dto> T getDto(Entity entity);
}
