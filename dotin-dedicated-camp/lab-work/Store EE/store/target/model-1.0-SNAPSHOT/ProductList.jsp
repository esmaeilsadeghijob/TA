<%--
  Created by IntelliJ IDEA.
  User: neloufar
  Date: 10/16/2021
  Time: 5:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>niloofar Store Application</title>
</head>
<body>
<div style="text-align: center;">
    <h1> niloofar shop </h1>
    <h2>
        <a href="new">Add New product</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All product</a>

    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5" bgcolor="#FFC0CB">
        <caption><h2>List of product</h2></caption>
        <tr>
            <th>ID</th>
            <th>nameP</th>
            <th>description</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="product" items="${listProduct}">
            <tr>
                <td><c:out value="${product.id}" /></td>
                <td><c:out value="${product.nameP}" /></td>
                <td><c:out value="${product.description}" /></td>
                <td><c:out value="${product.price}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${product.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${product.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
