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
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${trip.name}"/></td>
        <td><c:out value="${trip.startDate}"/></td>
        <td><c:out value="${trip.endDate}"/></td>
        <td><c:out value="${trip.description}"/></td>
        <td>
        </td>
    </tr>

    </tbody>
</table>
<ul><c:forEach items="${places}" var="place">
    <li>${place.name}<img src="${place.photo}"/><a href = "${place.location}">lokalizacja</a></li>
</c:forEach>
<li><a href = "places/add/${trip.id}">dodaj</a></li>
</ul>
</body>
</html>


