<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Place List</title>
</head>
<body>
<table border="1">
    <thead>
    <th>name</th>
    <th>location</th>
    <th>photo</th>
    <th>description</th>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${place.name}"/></td>
        <td><c:out value="${place.location}"/></td>
        <td><c:out value="${place.photo}"/></td>
        <td><c:out value="${place.description}"/></td>
        <td>
        </td>
    </tr>

    </tbody>
</table>
<div id="map-container-google-3" class="z-depth-1-half map-container" style="height: 500px">
    <iframe src="https://maps.google.com/maps?q=london
  &t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0"
            style="border:0" allowfullscreen></iframe>
</div>
</body>
</html>


