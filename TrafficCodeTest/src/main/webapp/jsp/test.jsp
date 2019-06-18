<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: dan
  Date: 11.06.2019
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>

<jsp:include page="header.jsp"/>
<body>
<div class="col-xs-1" align="center" style="margin: 10% 10% 3%">
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
        <ul class="pagination justify-content-center pagination-lg" style="margin: 20% 0% 0%">
            <li class="page-item <c:if test="${question == 1}">
        disabled
        </c:if>
">
                <input type="submit" name="action" value="Back" class="page-link">
            </li>
            <li class="page-item  <c:if test="${question == noOfTests}">
        disabled
        </c:if>">
                <input type="submit" name="action" value="Next" class="page-link

        ">
            </li>
            <li>
                <input type="submit" name="action" value="Finish" class="page-item page-link">
            </li>
        </ul>

        <ul class="pagination justify-content-center pagination-lg">
            <c:forEach begin="1" end="${noOfTests}" var="i">

                <c:if test="${question == i}">
                    <li class="page-item disabled">
                        <a class="page-link" tabindex="-1" aria-disabled="true">${i}</a>
                    </li>
                </c:if>
                <c:if test="${question != i}">
                    <li class="page-item">
                            <input name="action" type="submit" value="${i}" class="page-link">
                    </li>
                </c:if>

            </c:forEach>
        </ul>
    </form>
</div>



</body>
<jsp:include page="footer.jsp"/>

