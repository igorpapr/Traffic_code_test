<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="" %>

<%--
  Created by IntelliJ IDEA.
  User: dan
  Date: 11.06.2019
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<p>Test</p>
<p><span id="seconds">00</span>:<span id="tens">00</span></p>
<button id="button-start">Start</button>
<button id="button-stop">Stop</button>
<button id="button-reset">Reset</button>

<div class="container">
    <p>${tests[question-1].description}</p>
    <c:choose>
        <c:when test="${tests[question-1].type == \"SINGLE\"}">
            <c:forEach var="answer" items="${tests[question-1].questions}">
                <input type="radio" name="answer" value="${answer}"/> ${answer}<br>
            </c:forEach>
        </c:when>
        <c:when test="${tests[question-1].type == \"MULTI\"}">
            <c:forEach var="answer" items="${tests[question-1].questions}">
                <input type="checkbox" name="answer" value="${answer}"/> ${answer}<br>
            </c:forEach>
        </c:when>
        <c:when test="${tests[question-1].type == \"COMPL\"}">
            <c:forEach var="questionVar" items="${tests[question-1].questions}">
                ${questionVar}
                <select name="${questionVar}">
                    <c:forEach var="answer" items="${tests[question-1].answers}">
                        <option> ${answer} </option>
                    </c:forEach>
                </select>
                <br>
            </c:forEach>
        </c:when>
    </c:choose>
</div>

<div class="pagination">
    <c:forEach begin="1" end="${noOfTests}" var="i">
        <c:if test="${question == i}">
            <button type="button" class="btn btn-primary" disabled>${i}</button>
        </c:if>
        <c:if test="${question != i}">
            <form action="" method="post">
                <input type="hidden" name="action" value="${i}">
                <input type="submit" value="${i}" class="btn btn-primary">
            </form>
        </c:if>
    </c:forEach>
</div>
<c:if test="${question != 1}">
    <form action="" method="post">
        <input type="hidden" name="action" value="back">
        <input type="submit" value="back" class="btn btn-secondary">
    </form>
</c:if>

<c:if test="${question != noOfTests}">
    <form action="" method="post">
        <input type="hidden" name="action" value="next">
        <input type="submit" value="next" class="btn btn-success">
    </form>
</c:if>


<form action="" method="post">
    <input type="hidden" name="action" value="finish">
    <input type="submit" value="finish" class="btn btn-primary">
</form>
<script src="js/stopwatch.js"></script>
</body>
</html>
