package com.javarush.quest.pogonin.repository.quest;

import com.javarush.quest.pogonin.entity.quest.Quest;

public interface QuestRepository {
    public Quest getQuest(String id);
}
