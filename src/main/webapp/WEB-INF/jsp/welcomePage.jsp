<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <title>Добро пожаловать</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../../static/css/general.scss">
</head>
<body>
<div class="center">
    <div id="questionForm" class="dialogWindow">
        <h1 style="color: #1f2020">Здесь будет какая нибудь история</h1>
        <br><br>
        <form action="/welcome">
            <input type="text" name="name" value="Введите ваше имя">
            <br><br><br>
            <button class="button" type="submit">Начать путешествие.</button>
        </form>
    </div>
</div>
</body>
</html>
