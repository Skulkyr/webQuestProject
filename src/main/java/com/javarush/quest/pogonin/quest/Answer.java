package com.javarush.quest.pogonin.quest;

public class Answer {
    private final String text;
    private final String NEXT_QUEST_KEY;

    public Answer(String text, String NEXT_QUEST_KEY) {
        this.text = text;
        this.NEXT_QUEST_KEY = NEXT_QUEST_KEY;
    }

    public String getText() {
        return text;
    }

    public String getNextQuestKey() {
        return NEXT_QUEST_KEY;
    }
}
