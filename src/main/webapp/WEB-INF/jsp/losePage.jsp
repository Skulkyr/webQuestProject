<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Quest failed</title>
    <meta charset="utf-8">
</head>
<body>
<h1 style="color: red">YOU LOSE</h1>
<form method="post">
    <input type="hidden" name="restart" value="true">
    <input type="submit" value="Начать заного">
</form>

<jsp:include page="footer.jsp"/>
</body>
</html>
