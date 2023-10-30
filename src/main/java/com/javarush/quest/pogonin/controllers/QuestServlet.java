package com.javarush.quest.pogonin.controllers;

import com.javarush.quest.pogonin.repository.QuestMap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet (name = "QuestServlet", urlPatterns = "/quest")
public class QuestServlet extends HttpServlet {
    private QuestMap questMap;

    @Override
    public void init() throws ServletException {
        super.init();
        questMap = QuestMap.getInstance();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("name") == null) {
            resp.sendRedirect("/welcome");
            return;
        }
            super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("questId") == null) {
            session.setAttribute("questId", "0-0");
            session.setAttribute("gameCount", 0);
        }

        req.setAttribute("quest", questMap.getQuest((String) session.getAttribute("questId")));

        req.getRequestDispatcher(
                questMap.getQuest((String) session.getAttribute("questId")).getPattern())
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String answerQuestId = req.getParameter("idAnswer");
        String sessionQuestId = (String) session.getAttribute("questId");
        String restart = req.getParameter("restart");

        if (restart != null && restart.equals("true")) {
            answerQuestId = "0-0";
            int gameCount = (int) session.getAttribute("gameCount") + 1;
            session.setAttribute("gameCount", gameCount);

        } else if (answerQuestId.compareTo(sessionQuestId) < 0)
            answerQuestId = sessionQuestId;

        session.setAttribute("questId", answerQuestId);
        req.setAttribute("quest", questMap.getQuest(answerQuestId));

        req.getRequestDispatcher(
                        questMap.getQuest(answerQuestId).getPattern())
                        .forward(req, resp);
    }
}
