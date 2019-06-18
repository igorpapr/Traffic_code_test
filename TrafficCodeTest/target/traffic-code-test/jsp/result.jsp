<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: nikita
  Date: 2019-06-17
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<body>
<h1 class="text-center" style="margin: 15% 0% 5%">Ваш результат: ${rightanswers}/${noOfTests}</h1>
<div class="d-flex justify-content-center ">
    <a href="/" class=" btn btn-primary">Головна сторінка</a>
</div>
</body>
<jsp:include page="footer.jsp"/>
