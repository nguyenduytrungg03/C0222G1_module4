<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2022
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>SETTINGS</title>
</head>
<body>
<form:form method="POST" action="/electronicMail" modelAttribute="electronicMail">
    <table>
        <tr>
            <td>Language:</td>
            <td>
                <form:select path="language">
                    <form:options items="${listLanguage}"/>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>Page Size:</td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:options items="${listPageSize}"/>
                </form:select>
                email per page
            </td>
        </tr>

        <tr>
            <td>Spams Filter:</td>
          <td> <form:checkbox path="spamsFilter"/>
              Enable spams filter</td>
        </tr>

        <tr>
            <td>Signature:</td>
          <td><form:textarea path="signature"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Update"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
