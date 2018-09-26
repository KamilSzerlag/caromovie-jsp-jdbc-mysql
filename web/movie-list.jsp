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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="css/webstyle.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="page-header">
        <div class="row">
            <div class="col-lg-6" align="left">
                <h2>Your movies list</h2>
            </div>
            <div class="col-lg-6" align="right">
                <h3>because we <i class="fas fa-heart"></i> movies </h3>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            <button id="add-button" class="btn top-buffer" type="submit"><i class="fas fa-plus"></i></button>
        </div>
        <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
            <div class="row top-buffer">
                <input type="text" name="name" id="inputID1" class="form-control" value="Title" title="Title" required="required">
            </div>
            <div class="row top-buffer">
                <input type="text" name="name" id="inputID2" class="form-control" value="Director" title="Title" required="required">
            </div>
        </div>
        <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">

        </div>

    </div>
    <div class="row top-buffer">
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>TITLE</th>
                    <th>DIRECTOR</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>WOJCIECH</td>
                    <td>SMAŻOWSKI</td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
        </div>
    </div>
</div>
<footer class="footer">
    <div class="container" align="center">
        <span class="text-muted">Created by<i class="fas fa-user-astronaut"></i> Kamil Szerląg</span>
    </div>
</footer>
</body>
</html>
<%--<form action="ServletMovieController" method="GET">
    <table align="center">

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
    <table align="center">

        <form action="ServletMovieController" method="get">

        <tr>
            <th>TITLE</th>
            <th>YEAR</th>
            <th>WATCHED</th>
            <th></th>

        <tr>
        <c:forEach var="tempMovie" items="${MOVIELIST}">
                <c:url var="tempLink" value="ServletMovieController">
                <c:param name="command" value="LOAD" />
                <c:param name="movieId" value="${tempMovie.id}" />
            </c:url>
        <tr>

            <td>${tempMovie.title}</td>
            <td>${tempMovie.year}</td>
            <td>${tempMovie.watched}</td>
            <td><input type="submit" name="title" value="${tempMovie.title}" ></td>

        </tr>
        </c:forEach>
        </form>
    </table>
--%>

