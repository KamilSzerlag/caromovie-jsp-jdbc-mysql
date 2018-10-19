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
                <h2 style="color: darkcyan"><b style="color: hotpink"><i>Caro</i></b>Movies</h2>
            </div>
            <div class="col-lg-6" align="right">
                <h3>because we <i class="fas fa-heart"></i> movies </h3>
            </div>
        </div>
    </div>
    <div class="row">
        <form action="ServletMovieController" method="get">
            <input type="hidden" name="command" value="ADD">
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
            </div>
            <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                <button id="add-button" class="btn top-buffer" type="submit" onclick="alert('Movie added!')"><i
                        class="fas fa-plus"></i>
                </button>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
                <div class="row top-buffer">
                    <input type="text" name="title" class="form-control" placeholder="Title..." title="Title"
                           required="required">
                </div>
                <div class="row top-buffer">
                    <input type="text" name="year" class="form-control" placeholder="Year..." title="Year"
                           required="required">
                </div>
            </div>
            <div class="col-xs-2 col-sm-2 col-md-2 col-lg-2">

            </div>
            </input>
        </form>
    </div>
    <div class="row top-buffer">
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
        </div>
        <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
            <c:if test="${MOVIE_LIST.size()>0}">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Title</th>
                    <th>Director</th>
                    <th>Status</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <form action="ServletMovieController" method="get">
                    <%--<input type="hidden" name="command" value="DELETE">--%>
                    <c:forEach var="tempMovie" items="${MOVIE_LIST}">
                        <c:url var="deleteMovie" value="ServletMovieController">
                            <c:param name="command" value="DELETE"></c:param>
                            <c:param name="id" value="${tempMovie.id}"></c:param>

                        </c:url>
                        <c:url var="updateLink" value="ServletMovieController">
                            <c:param name="command" value="UPDATE"></c:param>
                            <c:param name="id" value="${tempMovie.id}"></c:param>
                        </c:url>
                        <tr>

                            <td>${tempMovie.title}</td>
                            <td>${tempMovie.year}</td>
                            <td><c:choose>
                                <c:when test="${tempMovie.watched==true}"><i class="far fa-thumbs-up"></i></c:when>
                                <c:otherwise><i class="far fa-times-circle"></i></c:otherwise>
                            </c:choose></td>
                            <td class="for-align">
                                    <%--TODO title -> id --%>
                                        <div class="btn-group">

                                            <a href="${deleteMovie}" class="btn btn-primary">
                                                <i
                                                        class="fas fa-minus"></i>
                                            </a>
                                            <a href="${updateLink}" class="btn btn-primary important-button">
                                                <i class="fas fa-film"></i>
                                            </a>
                                        </div>


                            </td>

                        </tr>
                    </c:forEach>
                    <%--</input>--%>
                </form>
                </tbody>
            </table>
            </c:if>
        </div>
        <div class="col-xs-3 col-sm-3 col-md-3 col-lg-3">
        </div>
    </div>
    <div class="row top-buffer">
        <form action="ServletMovieController" method="post">
            <input type="hidden" name="command" value="UPDATE_PROGRESS">
            <div class="progress">
                <c:set var="progress" value="${PROGRESS}" scope="request"></c:set>
                <div class="progress-bar" role="progressbar" style="width: ${progress}%; background: hotpink"
                     aria-valuenow="${progress}" aria-valuemin="0" aria-valuemax="100">${progress}%
                </div>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">

            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4" align="center">

            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 ">

            </div>

            </input>
        </form>
    </div>
</div>
<%--<footer class="footer">
    <div class="container" align="center">
        <span class="text-muted">Created by<i class="fas fa-user-astronaut"></i> Kamil Szerląg</span>
    </div>
</footer>--%>
</body>
</html>


