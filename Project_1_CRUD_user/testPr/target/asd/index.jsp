<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>ТЕстовое задание by SaiDHAzzarD</title>
    <link href="index.css" rel="stylesheet" type="text/css" >
</head>
<body>
<br>
<center>
    <h1 class="h">МегаТабличка с ЛУзерами</h1>
    <form method="get">
        <table border = 2 class="tabla">
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Password</th>
                <th>Name</th>
                <th>Role</th>
                <th>UPDATE</th>
                <th>DELETE</th>
            </tr>
            <c:forEach var="Users" items="${list}">
            <tr>
                <th><c:out value="${Users.id}"/></th>
                <th><c:out value="${Users.login}"/></th>
                <th><c:out value="${Users.password}"/></th>
                <th><c:out value="${Users.name}"/></th>
                <th><c:out value="${Users.role}"/></th>
                <th><a href="/update?id=<c:out value="${Users.id}"/>" style=text-decoration:none;"><input type="button" id="update_user" value="Изменить" class="tag"/></a></th>
                <th><a href="/delete?id=<c:out value="${Users.id}"/>" style=text-decoration:none;"><input type="button" id="delete_user" value="Delete" class="tag"/></a></th>
            </tr>
            </c:forEach>
            <tr>
            <th colspan="7"><a href="add_user.jsp" style="text-decoration:none;">
            <input type="button" action = "/add" id="add_user" value="Добавить" class="tag"/>
            </a></th>
            </tr>
        </table>
    </form>
</center>
<br>
</body>
</html>