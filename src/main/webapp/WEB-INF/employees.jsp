<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table border=1>
    <tr>
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>First name</b></td>
        <td><b>Home phone</b></td>
        <td><b>Mobile phone</b></td>
        <td><b>Pro phone</b></td>
        <td><b>Address</b></td>
        <td><b>Postal Code</b></td>
        <td><b>City</b></td>
        <td><b>Email</b></td>
    </tr>

    <c:forEach items="${empList}" var="employee">
        <tr>
            <td> ${employee.id} </td>
            <td> ${employee.name}</td>
            <td> ${employee.firstname} </td>
            <td> ${employee.homePhone}</td>
            <td> ${employee.mobilePhone}</td>
            <td> ${employee.proPhone}</td>
            <td> ${employee.address}</td>
            <td> ${employee.postalCode}</td>
            <td> ${employee.city} </td>
            <td> ${employee.mail} </td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
