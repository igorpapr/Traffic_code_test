<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
${tests}
<div class="container">
    <p>${tests[question-1].description}</p>
    <form action="" method="post">
        <c:choose>

            <c:when test="${tests[question-1].type == \"SINGLE\"}">
                <c:forEach begin="1" end="4" var="i">
                    <c:choose>
                        <c:when test="${answers[question-1].answer == i}">
                            <input type="radio" name="answer" value="${tests[question-1].questions[i-1]}"
                                   checked/> ${tests[question-1].questions[i-1]}<br>
                        </c:when>
                        <c:otherwise>
                            <input type="radio" name="answer"
                                   value="${tests[question-1].questions[i-1]}"/> ${tests[question-1].questions[i-1]}<br>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:when>

            <c:when test="${tests[question-1].type == \"MULTI\"}">
                <c:forEach begin="1" end="4" var="i">
                    <input type="checkbox" name="answer" value="${tests[question-1].questions[i-1]}"
                            <c:forEach var="item" items="${answers[question-1].answers}">
                                <c:if test="${item eq i}">
                                    checked
                                </c:if>
                            </c:forEach>
                    />
                    ${tests[question-1].questions[i-1]}
                    <br>
                </c:forEach>
            </c:when>

            <c:when test="${tests[question-1].type == \"COMPL\"}">
                <c:forEach var="questionVar" items="${tests[question-1].questions}">
                    ${questionVar}
                    <select name="answer">
                        <option></option>
                        <c:forEach var="i" begin="0" end="3">
                            <option value="${tests[question-1].answers[i]}"
<%--                                    <c:set var="flagq" value="${true}"/>--%>
<%--                                    <c:forEach var="j" begin="0" end="3">--%>
<%--                                        <c:if test="${tests[question-1].answers[j] == answers[question-1].answers[i] && flagq &&--%>
<%--                                         fn:length(answers[question-1].answers) > 0}">--%>
<%--                                            selected--%>
<%--                                            <c:set var="flagq" value="${false}"/>--%>
<%--                                        </c:if>--%>
<%--                                    </c:forEach>--%>
                            > ${tests[question-1].answers[i]} </option>
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

        <input type="submit" name="action" value="finish" class="btn btn-primary">
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


</body>
</html>
