<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Create New Product</title>
</head>
<body>
<div align="center">
<form:form method="post" modelAttribute="user" action="/save">
    <table border="1">
        <tr>
            <th colspan="2">Insert User</th>
        </tr>
        <tr>
            <form:hidden path="id" />
            <td><form:label path="name">Name:</form:label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="surname">Surname:</form:label></td>
            <td><form:input path="surname"></form:input></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" /></td>
        </tr>
    </table>
</form:form>
</div>
</body>
</html>