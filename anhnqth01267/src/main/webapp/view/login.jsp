<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 4/12/24
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>${m1}</h2>
<form action="/asm-filter/login" method="post">
    Username: <input type="text" name="username"> <br>
    Password: <input type="text" name="password"> <br>
    <button type="submit">Login</button>
</form>
</body>
</html>
