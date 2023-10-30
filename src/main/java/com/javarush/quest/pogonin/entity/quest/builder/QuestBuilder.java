package com.javarush.quest.pogonin.entity.quest.builder;

import com.javarush.quest.pogonin.entity.quest.Quest;

public abstract class QuestBuilder {
    protected final String PATCH;

    public QuestBuilder(String... params) {
        this.PATCH = params[0];
    }

    public abstract QuestBuilder addAnswer(String text, String nextQuestId);

    public abstract QuestBuilder setQuestText(String questText);

    public abstract QuestBuilder reset();

    public abstract Quest build();

    public abstract QuestBuilder setPatch(String patch);
}
