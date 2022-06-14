<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/14/2022
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Từ Điển</title>
  </head>
  <body>
  <form action="change" method="post">
    <div>
      <p>Từ Điển</p>
    </div>
    <div>
      <label>ENGLISH</label>
      <input type="text" name="name" value="${name}">
    </div>
    <div>
      <label>VIETNAMESE: </label>
      <label>${result} </label>
    </div>
    <div>
      <input type="submit" value="change">
    </div>
  </form>

  </body>
</html>
