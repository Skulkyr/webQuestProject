<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <title>Quest failed</title>
    <meta charset="utf-8">
</head>
<body>
<div class="center">
    <div class="dialogWindow">
        <form method="post">
            <legent><h1 style="color: #ff0000">YOU LOSE</h1></legent>
            <br><br><br>
            <input type="hidden" name="restart" value="true">
            <button class="button" type="submit">Restart</button>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>