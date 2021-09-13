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
        <td><c:out value="${tripEntity.name}"/></td>
        <td><c:out value="${tripEntity.startDate}"/></td>
        <td><c:out value="${tripEntity.endDate}"/></td>
        <td><c:out value="${tripEntity.description}"/></td>
        <td>
        </td>
    </tr>

    </tbody>
</table>
<ul><c:forEach items="${places}" var="placeEntity">
    <li>${placeEntity.name}<img src="${placeEntity.photo}"/><a href ="https://www.google.com/maps/@${placeEntity.location}">Localization</a>
        <a href = "/places/editPlaces/${placeEntity.id}">Edit placeEntity</a>
        <a href = "/places/deletePlaces/${placeEntity.tripId}/${placeEntity.id}">Delete placeEntity</a>
        <a href = "/places/showPlaces/${placeEntity.id}">Details</a>
    </li>
</c:forEach>
<li><a href = "/places/addPlaces/${trip.id}">Add new placeEntity</a></li>
</ul>
</body>
</html>


