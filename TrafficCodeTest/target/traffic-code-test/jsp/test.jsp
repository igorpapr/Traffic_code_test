<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<div class="container">
    <p>${tests[question-1].description}</p>
    <form action="" method="post">
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
                    <select name="answer">
                        <c:forEach var="answer" items="${tests[question-1].answers}">
                            <option value=${answer}> ${answer} </option>
                        </c:forEach>
                    </select>
                    <br>
                </c:forEach>
            </c:when>
        </c:choose>

        <c:if test="${question != 1}">
            <input type="submit" name="action" value="back" class="btn btn-secondary">
        </c:if>

        <c:if test="${question != noOfTests}">
            <input type="submit" name="action" value="next" class="btn btn-success">
        </c:if>

    </form>
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


<form action="" method="post">
    <input type="hidden" name="action" value="finish">
    <input type="submit" value="finish" class="btn btn-primary">
</form>
</body>
</html>
