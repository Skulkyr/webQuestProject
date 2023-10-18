package com.example.webquestproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcome", "/"})
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("name") == null)
        req.getRequestDispatcher("WEB-INF/jsp/welcomePage.jsp").forward(req, resp);
        else resp.sendRedirect("/quest");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("name") != null) {
            session.setAttribute("name", req.getParameter("name"));
            resp.sendRedirect("/quest");
        }else req.getRequestDispatcher("WEB-INF/jsp/welcomePage.jsp").forward(req, resp);
    }
}
