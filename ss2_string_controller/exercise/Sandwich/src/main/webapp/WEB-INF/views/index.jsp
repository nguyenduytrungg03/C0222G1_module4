<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2022
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich Condiments</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>

  <form action="/sandwich" method="post">
    <input type="checkbox" id="vehicle1" name="condiment" value="Lettuce">
    <label for="vehicle1">Lettuce</label><br>
    <input type="checkbox" id="vehicle2" name="condiment" value="Tomato">
    <label for="vehicle2"> Tomato</label><br>
    <input type="checkbox" id="vehicle3" name="condiment" value="Mustard">
    <label for="vehicle3">Mustard</label><br>
    <input type="checkbox" id="vehicle4" name="condiment" value="Sprouts">
    <label for="vehicle4"> Sprouts</label><br>
    <input type="submit" value="Submit"><br>
  </form>

  </body>
</html>
