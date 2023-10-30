package com.javarush.quest.pogonin.entity.quest.builder;

public class QuestBuilderFactory {
    public static QuestBuilder getQuestBuilder(QuestFactoryType type, String... params) {
        return switch (type) {
            case jspQuest -> new jspQuestBuilder(params);
        };
    }
}
