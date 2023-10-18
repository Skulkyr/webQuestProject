package com.example.webquestproject;

import com.example.webquestproject.quest.questMap.QuestMap;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("questId") == null || session.getAttribute("name") == null) {
            session.setAttribute("questId", "0-0");
            session.setAttribute("gameCount", 1);
            resp.sendRedirect("/welcome");
        }

        req.setAttribute("quest", questMap.getQuest((String) session.getAttribute("questId")));

        req.getRequestDispatcher(
                questMap.getQuest((String) session.getAttribute("questId")).getPattern())
                .include(req, resp);
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
                        questMap.getQuest((String) session.getAttribute("questId")).getPattern())
                        .include(req, resp);
    }
}
