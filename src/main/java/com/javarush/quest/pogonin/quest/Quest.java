package com.javarush.quest.pogonin.quest;

public interface Quest {
    // This method return text of question.
     String getQuestion(String name);

    // This method return array of answer variants.
     Answer[] getAnswerVariants(String name);

     String getPattern();


}
