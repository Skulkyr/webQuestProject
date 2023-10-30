package com.javarush.quest.pogonin.repository;

import com.javarush.quest.pogonin.entity.quest.builder.QuestFactoryType;
import com.javarush.quest.pogonin.entity.quest.builder.QuestBuilderFactory;
import com.javarush.quest.pogonin.entity.quest.builder.QuestBuilder;
import com.javarush.quest.pogonin.entity.quest.Quest;

import java.util.HashMap;
import java.util.Map;

public class QuestMap {
    private final Map<String, Quest> QUEST_MAP;

    private static volatile QuestMap map;

    private QuestMap(Map<String, Quest> map) {
        QUEST_MAP = map;
    }

    public Quest getQuest(String key) {
        return QUEST_MAP.get(key);
    }

    public static QuestMap getInstance() {
        QuestMap localMap = map;

        if (localMap == null) {
            synchronized (QuestMap.class) {

                localMap = map;

                if (localMap == null) {
                    map = new QuestMap(createQuestMap());
                }
            }
        }

        return map;
    }

    private static Map<String, Quest> createQuestMap() {
        Map<String, Quest> map = new HashMap<>();
        QuestBuilder builder = QuestBuilderFactory.getQuestBuilder(QuestFactoryType.jspQuest, "WEB-INF/jsp/quest.jsp");

        map.put("0-0",
                builder.setQuestText("Ты потерял память.<br><b>Принять вызов НЛО?</b>")
                        .addAnswer("Принять вызов.", "1-0")
                        .addAnswer("Отклонить вызов.", "1-1")
                        .build());

        map.put("1-0",
                builder.setQuestText("Ты принял вызов.<br>Поднимаешься на мостик к капитану?")
                        .addAnswer("Поднятся на мостик.", "2-0")
                        .addAnswer("Отказаться подниматься на мостик.", "2-1")
                        .build());

        map.put("1-1",
                builder.setQuestText("Ты отклонил вызов.<br><b>ПОРАЖЕНИЕ!</b>")
                        .setPatch("WEB-INF/jsp/losePage.jsp")
                        .build());

        map.put("2-0",
                builder.setQuestText("Ты поднялся на мостик.<br>Ты кто?")
                        .addAnswer("Рассказать правду о себе.", "3-0")
                        .addAnswer("Солгать о себе.", "3-1")
                        .build());

        map.put("2-1",
                builder.setQuestText("Ты не пошел на переговоры.<br><b>ПОРАЖЕНИЕ!</b>")
                        .setPatch("WEB-INF/jsp/losePage.jsp")
                        .build());

        map.put("3-0",
                builder.setQuestText("Тебя вернули домой.<br><b>ПОБЕДА!</b>")
                        .setPatch("WEB-INF/jsp/winPage.jsp")
                        .build());

        map.put("3-1",
                builder.setQuestText("Твоя ложь разоблачена.<br><b>ПОРАЖЕНИЕ!</b>")
                        .setPatch("WEB-INF/jsp/losePage.jsp")
                        .build());
        return map;
    }
}
