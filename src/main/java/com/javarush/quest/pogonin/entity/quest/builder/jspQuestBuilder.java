package com.javarush.quest.pogonin.entity.quest.builder;

import com.javarush.quest.pogonin.entity.quest.Answer;
import com.javarush.quest.pogonin.entity.quest.Quest;
import com.javarush.quest.pogonin.entity.quest.jspQuest;


public class jspQuestBuilder extends QuestBuilder {

    private jspQuest quest;

    protected jspQuestBuilder(String... params) {
        super(params);
        quest = new jspQuest();
        quest.setJspPatch(PATCH);
    }

    @Override
    public QuestBuilder addAnswer(String text, String nextQuestId) {
        quest.addAnswers(new Answer(text, nextQuestId));
        return this;
    }

    @Override
    public QuestBuilder setQuestText(String questText) {
        quest.setQuestText(questText);
        return this;
    }

    @Override
    public QuestBuilder reset() {
        quest = new jspQuest();
        quest.setJspPatch(PATCH);
        return this;
    }

    @Override
    public Quest build() {
        Quest result = quest;
        reset();
        return result;
    }

    @Override
    public QuestBuilder setPatch(String patch) {
        quest.setJspPatch(patch);
        return this;
    }
}
