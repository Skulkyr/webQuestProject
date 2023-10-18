package com.example.webquestproject.quest;

import java.util.ArrayList;

public class jspQuest implements Quest {
    private String jspPatch;
    private final ArrayList<Answer> answers = new ArrayList<>();
    private String questText;

    public jspQuest() {
    }

    @Override
    public String getPattern() {
        return jspPatch;
    }

    @Override
    public String getQuestion(String name) {
        return questText;
    }

    @Override
    public Answer[] getAnswerVariants(String name) {
        return toArray();
    }

    public void setJspPatch(String jspPatch) {
        this.jspPatch = jspPatch;
    }

    public void addAnswers(Answer answer) {
        answers.add(answer);
    }

    public void setQuestText(String questText) {
        this.questText = questText;
    }

    private Answer[] toArray() {
        Answer[] result = new Answer[answers.size()];
        for (int i = 0; i < answers.size(); i++)
            result[i] = answers.get(i);
        return result;
    }
}
