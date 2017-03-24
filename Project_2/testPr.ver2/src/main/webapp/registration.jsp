<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ТЕстовое задание by SaiDHAzzarD</title>
    <link href="index.css" rel="stylesheet" type="text/css" >
</head>
<body>
<center>
    <h1>Введите данные нового пользователя</h1>
    <form action="/reg" method="POST">
        <table border="3">
            <tbody>
            <tr>
                <td>Login:</td>
                <td> <input type="text" name="login"  size="20" required/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>  <input type="text" name="password"  size="20" required/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>  <input type="text" name="name"  size="20" required/></td>
            </tr>
            <input type="hidden" name="role" value="user"/>
            <tr>
                <td colspan = "2"><input type="submit" value="Join" class="tag"/></td>
            </tr>
        </table>
    </form>
</center>
<br>
</body>
</html>