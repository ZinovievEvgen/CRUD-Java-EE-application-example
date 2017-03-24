<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<center>
    <h1>Вы вошли под логином: <c:out value="${user.login}"/></h1>
    <c:out value="${user.role}"/>
</center>
</body>
</html>
