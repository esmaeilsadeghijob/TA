<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form method="get" action="hello-servlet">
<h2>Please enter the amount of numbers that you want to enter :</h2>
    <br/>
    <input type="number" name="arrayLength" required>
    <button type="submit" value="submit">Submit</button>
</form>
</body>
</html>