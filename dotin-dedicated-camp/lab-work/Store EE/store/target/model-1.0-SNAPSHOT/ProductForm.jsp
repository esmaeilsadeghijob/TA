<%--
  Created by IntelliJ IDEA.
  User: neloufar
  Date: 10/16/2021
  Time: 5:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>niloooofar shop Application</title>
</head>
<body>
<div style="text-align: center;">
    <h1>niloooofar store Management</h1>
    <h2>
        <a href="new">Add New product</a>
        &nbsp;
        <a href="list">List All product</a>
    </h2>
</div>
<div align="center">
    <c:if test="${product != null}">
    <form action="update" method="post">
        </c:if>
           <c:if test="${product == null}">
               <form action="insert" method="post">
                  </c:if>
                    <table border="1" cellpadding="5" bgcolor="#FFC0CB">
                <caption>
                    <h2>
                        <c:if test="${product != null}">
                            Edit product
                        </c:if>
                        <c:if test="${product == null}">
                            Add New product
                        </c:if>
                    </h2>
                </caption>
                        <c:if test="${product != null}">
                        <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
                        </c:if>
                        <tr>
                            <th>nameP: </th>
                            <td>
                                <input type="text" name="nameP" size="45"
                                       value="<c:out value='${product.nameP}' />"/>
                            </td>
                        </tr>
                        <tr>
                            <th>description: </th>
                            <td>
                                <input type="text" name="description" size="45"
                                       value="<c:out value='${product.description}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <th>Price: </th>
                            <td>
                                <input type="text" name="price" size="5"
                                       value="<c:out value='${product.price}' />"
                                />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input type="submit" value="Save" />
                            </td>
                        </tr>
                    </table>
               </form>
</div>

</body>
</html>
