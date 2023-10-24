<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../../static/css/general.css">
</head>
<body>
<div class="glass">
    <h3>Статистика:</h3>
    <ul>
        <li>IP address: <%=request.getRemoteAddr()%></li>
        <li>Имя в игре: <%=request.getSession().getAttribute("name")%></li>
        <li>Количество игр: <%=request.getSession().getAttribute("gameCount")%></li>
    </ul>
</div>
</body>
</html>
