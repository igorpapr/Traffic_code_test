<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: dan
  Date: 11.06.2019
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<body>
<div class="container" style="margin: 10%">
    <h2>Привіт! 👋</h2>
    <p>Тебе вітає Веб-сайт для проходження тестів з ПДР!</p>
    <p>Якщо готовий(а), то полетіли ... </p>

        <form style="margin-top: 50px" action="" method="post" class="text-center">
            <input type="hidden" name="action" value="edit">
            <input type="submit" value="🚀" class="btn btn-lg border border-warning">
        </form>
</div>



</body>
<jsp:include page="footer.jsp"/>



