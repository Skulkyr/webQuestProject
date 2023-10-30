package com.javarush.quest.pogonin.entity.quest;

import com.javarush.quest.pogonin.entity.AbstractEntity;
import com.javarush.quest.pogonin.entity.Entity;

public abstract class Quest extends AbstractEntity implements Entity {
    // This method return text of question.
     public abstract String getQuestion(String name);

    // This method return array of answer variants.
     public abstract Answer[] getAnswerVariants(String name);

     public abstract String getPattern();


}
