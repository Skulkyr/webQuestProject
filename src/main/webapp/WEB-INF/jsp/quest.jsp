<%@ page language="java" contentType="text/html;charset=cp1251"%>
<%@ page import="com.example.webquestproject.quest.Answer" %>
<%@ page import="com.example.webquestproject.quest.Quest" %>
<%Quest quest = (Quest) request.getAttribute("quest");
  Answer[] answers = quest.getAnswerVariants("");%>
<html lang="ru">
<head>
    <title>Quest</title>
    <meta charset="utf-8">
    <script src="../../static/js/jspStandard.js"></script>
</head>
<body>
<div>
    <%=quest.getQuestion("")%>
    <br>
<form method="post">
    <% for(int i = 0; i < answers.length; i++) {%>
    <%=answers[i].getText()%>
    <input type="checkbox" name="idAnswer" value="<%=answers[i].getNextQuestKey()%>" onchange="onlyOne(this)"/>
    <br>
    <%}%>
    <input type="submit" value="Ответить">
</form>

    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
