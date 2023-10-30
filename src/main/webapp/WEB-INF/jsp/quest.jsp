<%@ page language="java" contentType="text/html;charset=cp1251" %>
<%@ page import="com.javarush.quest.pogonin.entity.quest.Answer" %>
<%@ page import="com.javarush.quest.pogonin.entity.quest.Quest" %>
<%
    Quest quest = (Quest) request.getAttribute("quest");
    Answer[] answers = quest.getAnswerVariants("");
%>
<html lang="ru">
<head>
    <title>Quest</title>
    <meta charset="utf-8">
    <script src="../../static/js/jspStandard.js"></script>
    <link rel="stylesheet" href="../../static/css/general.scss">
</head>
<body>

<div class="center">
    <div id="questionForm" class="dialogWindow">
    <form id="answerForm" method="post">
        <fieldset class="chkgroup" role="radiogroup" aria-labelledby="question">
            <legend id="question"><%=quest.getQuestion("")%></legend>
        <% for (int i = 0; i < answers.length; i++) {%>
        <input id="answer<%=i%>" type="radio" name="idAnswer" value="<%=answers[i].getNextQuestKey()%>"/>
        <label for="answer<%=i%>"><%=answers[i].getText()%></label>
        <%}%>
        </fieldset>
        <button class="button" type="submit">Ответить</button>
    </form>
    </div>

</div>
<jsp:include page="footer.jsp"/>

</body>
</html>
