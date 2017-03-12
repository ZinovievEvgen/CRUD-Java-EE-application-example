<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ТЕстовое задание by SaiDHAzzarD</title>
    <link href="index.css" rel="stylesheet" type="text/css" >
</head>
<body>
<center>
<h1>Измените необходимые данные пользователя</h1>
    <c:set target="${userById}" property="id" value="${userById.id}" />
    <c:set target="${userById}" property="login" value="${userById.login}" />
    <c:set target="${userById}" property="password" value="${userById.password}" />
    <c:set target="${userById}" property="name" value="${userById.name}" />
    <c:set target="${userById}" property="role" value="${userById.role}" />
    <form action="/update" method="POST">
        <table border="2">
            <tbody>
            <input type="hidden" name="id"  size="20" value="<c:out value="${userById.id}" default="NO DATA"/>"/>
            <tr>
                <td>Update Login:</td>
                <td> <input type="text" name="login"  size="20" value="<c:out value="${userById.login}" default="NO DATA"/>"/></td>
            </tr>
            <tr>
                <td>Update Password:</td>
                <td> <input type="text" name="password"  size="20" value="<c:out value="${userById.password}" default="NO DATA"/>"/></td>
            </tr>
            <tr>
                <td>Update Name:</td>
                <td>  <input type="text" name="name"  size="20" value="<c:out value="${userById.name}" default="NO DATA"/>"/></td>
            </tr>
            <tr>
                <td>Update Role:</td>
                <td>  <input type="text" name="role"  size="20" value="<c:out value="${userById.role}" default="NO DATA"/>"/></td>
            </tr>
            <tr>
                <td colspan = "2"><input type="submit" value="Join" class="tag"/></td>
            </tr>
        </table>
    </form>
</center>
<br>
</body>
</html>