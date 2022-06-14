<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/14/2022
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển Đổi Tiền Tệ</title>
</head>
<body>
<form action="currency" method="post">
    <div>
        <p>Chuyển đổi tiền tệ</p>
    </div>
    <div>
        <label>Usd</label>
        <input type="text" name="usd" value="${usd}">
    </div>
    <div>
        <label>Result: </label>
        <label>${result} Vnđ</label>
    </div>
    <div>
        <input type="submit" value="change">
    </div>
</form>
</body>
</html>
