<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Test Project Java</title>
    <link href="index.css" rel="stylesheet" type="text/css" >
</head>
<body>
<center>
<h1>Выберите необходимую операцию</h1>
<form id="path" method="get">
    <a href="/registration.jsp" style=text-decoration:none;"><input type="button" id="registration" value="Registration" class="tag"/></a>
    <a href="/LogOut.jsp" style=text-decoration:none;"><input type="button" id="log" value="Join" class="tag"/></a>

    <br>
    <br>
    <b><c:out value="${err}"/></b>
</form>
</center>
</body>
</html>
