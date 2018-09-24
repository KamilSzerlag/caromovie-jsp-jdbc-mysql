<%--
  Created by IntelliJ IDEA.
  User: szerlag
  Date: 2018-09-24
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>


</head>
<body>
    <table>
        <tr>
            <th>TITLE</th>
            <th>YEAR</th>
            <th>WATCHED</th>
        <tr>
        <c:forEach var="tempMovie" items="${MOVIELIST}">
        <tr>

            <td>${tempMovie.title}</td>
            <td>${tempMovie.year}</td>
            <td>${tempMovie.watched}</td>


        </tr>
        </c:forEach>
    </table>

</body>
</html>
