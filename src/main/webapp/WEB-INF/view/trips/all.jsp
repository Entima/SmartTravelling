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
    <th><a href="/trip/add">Add new trip</a></th>
    </thead>
    <tbody>
    <c:forEach items="${trips}" var="trip">
        <tr>
            <td><c:out value="${trip.name}"/></td>
            <td><c:out value="${trip.startDate}"/></td>
            <td><c:out value="${trip.endDate}"/></td>
            <td><c:out value="${trip.description}"/></td>
            <td><a href = "/trip/edit/<c:out value="${trip.id}"/>">Edit</a></td>
            <td><a href = "/trip/delete/<c:out value="${trip.id}"/>">Delete</a></td>
            <td><a href = "/trip/show/<c:out value="${trip.id}"/>">Details</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>


