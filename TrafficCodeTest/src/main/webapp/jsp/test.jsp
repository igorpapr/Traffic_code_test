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

<p>${tests}</p>

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
