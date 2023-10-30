package com.javarush.quest.pogonin.mappers;

import com.javarush.quest.pogonin.entity.Entity;
import com.javarush.quest.pogonin.mappers.exceptions.EntityIncompatibleType;

public abstract class AbstractMapper implements Mapper{
    void checkCorrectEntity(Entity entity, Class<? extends Entity> clazz) {
        if (!clazz.isInstance(entity))
            throw new EntityIncompatibleType();
    }
}
