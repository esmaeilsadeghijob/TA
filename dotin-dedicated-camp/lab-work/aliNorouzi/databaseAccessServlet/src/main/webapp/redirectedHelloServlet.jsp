<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Redirected</title>
</head>
<body bgcolor="#f0f0f0">
<h1 align=\"center\">Redirected</h1>
<ul>
    <li>
        <b> First Name </b>:
        <%=request.getParameter("first_name")%>
    </li>
    <li>
        <b> Last Name : </b>
        <%=request.getParameter("last_name")%>
    </li>
    <li>
        <b> Age : </b>
        <%=request.getParameter("age")%>
    </li>
    <h1> Hello <%=request.getParameter("first_name")%> <%=request.getParameter("last_name")%> , <%=request.getParameter("age")%> sale az Tehran. </h1>
</ul>
</body>
</html>
