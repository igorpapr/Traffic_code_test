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
</head>
<body>
<p>Test</p>
<c:forEach var="test" items="${tests}">
    <div>
        <p>${test.description}</p>
        <c:choose>
            <c:when test="${test.type == \"SINGLE\"}">
                <c:forEach var="answer" items="${test.questions}">
                    <input type="radio" name="answer" value="${answer}"/> ${answer}<br>
                </c:forEach>
            </c:when>
            <c:when test="${test.type == \"MULTI\"}">
                <c:forEach var="answer" items="${test.questions}">
                    <input type="checkbox" name="answer" value="${answer}"/> ${answer}<br>
                </c:forEach>
            </c:when>
            <c:when test="${test.type == \"COMPL\"}">
                <c:forEach var="question" items="${test.questions}">
                    ${question}
                    <select name="${question}">
                        <c:forEach var="answer" items="${test.answers}">
                            <option> ${answer} </option>
                        </c:forEach>
                    </select>
                    <br>
                </c:forEach>
            </c:when>
        </c:choose>
    </div>
</c:forEach>
<%--<p>${tests[0].}</p>--%>

<form action="" method="post">
    <input type="hidden" name="action" value="back">
    <input type="submit" value="back">
</form>


<form action="" method="post">
    <input type="hidden" name="action" value="next">
    <input type="submit" value="next">
</form>


<form action="" method="post">
    <input type="hidden" name="action" value="finish">
    <input type="submit" value="finish">
</form>

</body>
</html>
