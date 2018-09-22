<%--
  Created by IntelliJ IDEA.
  User: szerlag
  Date: 2018-09-23
  Time: 00:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>MOVIE</title>
</head>
<body>
<h3>MOVIE</h3>
<form action="ServletMovieController" method="GET">
<table>

    <tr>
        <td><label>TITLE:</label></td>
        <td><input type="text" name="title"></td>
    </tr>

    <tr>
        <td><label>YEAR:</label></td>
        <td><input type="text" name="year"></td>
    </tr>
    <tr>
        <td><label></label></td>
        <td><input type="submit" value="Save" class="save" /></td>
    </tr>
</table>
</form>
</body>
</html>
