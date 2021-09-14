<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Trip List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>name</th>
    <th>startDate</th>
    <th>endDate</th>
    <th>description</th>
    <th><a href="/trips/add">Add new trip</a></th>
    </thead>
    <tbody>
    <c:forEach items="${trips}" var="tripEntity">
        <tr>
            <td><c:out value="${tripEntity.name}"/></td>
            <td><c:out value="${tripEntity.startDate}"/></td>
            <td><c:out value="${tripEntity.endDate}"/></td>
            <td><c:out value="${tripEntity.description}"/></td>
            <td><a href = "/trips/edit/<c:out value="${tripEntity.id}"/>">Edit</a></td>
            <td><a href = "/trips/delete/<c:out value="${tripEntity.id}"/>">Delete</a></td>
            <td><a href = "/trips/show/<c:out value="${tripEntity.id}"/>">Details</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>


