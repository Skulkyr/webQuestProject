package com.example.webquestproject.builder;

public class QuestBuilderFactory {
    public static QuestBuilder getQuestBuilder(FactoryType type, String... params) {
        return switch (type) {
            case jspQuest -> new jspQuestBuilder(params);
        };
    }
}
