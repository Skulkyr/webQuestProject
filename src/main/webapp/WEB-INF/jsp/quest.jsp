<%@ page language="java" contentType="text/html;charset=cp1251" %>
<%@ page import="com.javarush.quest.pogonin.quest.Answer" %>
<%@ page import="com.javarush.quest.pogonin.quest.Quest" %>
<%
    Quest quest = (Quest) request.getAttribute("quest");
    Answer[] answers = quest.getAnswerVariants("");
%>
<html lang="ru">
<head>
    <title>Quest</title>
    <meta charset="utf-8">
    <script src="../../static/js/jspStandard.js"></script>
    <link rel="stylesheet" href="../../static/css/general.css">
</head>
<body>

<div class="center">
    <div id="question" class="dialogWindow">
        <h2 id="textQuestion"><%=quest.getQuestion("")%></h2>

    <form id="answerForm" method="post">
        <% for (int i = 0; i < answers.length; i++) {%>
        <input id="answer${i}" type="radio" name="idAnswer" value="<%=answers[i].getNextQuestKey()%>"/>
        <label for="answer${i}"><%=answers[i].getText()%></label>
        <br>
        <%}%>
        <input type="submit" value="Ответить">
    </form>
    </div>

</div>
<jsp:include page="footer.jsp"/>

</body>
</html>
