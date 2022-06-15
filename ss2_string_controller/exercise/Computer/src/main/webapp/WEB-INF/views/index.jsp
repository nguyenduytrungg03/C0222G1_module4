<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2022
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="post">
    <p>Calculator</p>
    <input type="text" name="number1" value="${number1}">
    <br>
    <input type="text" name="number2" value="${number2}">
    <br>
    <button name="operator" value="+">Addition(+)</button>
    <button name="operator" value="-">Subtraction(-)</button>
    <button name="operator" value="*">Multiplication(X)</button>
    <button name="operator" value="/">Division(/)</button>
</form>
<p>Result: ${result} </p>
</body>
</html>
