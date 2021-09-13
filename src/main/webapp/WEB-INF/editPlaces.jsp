<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Place add</title>
</head>
<body>

<form:form method="post" modelAttribute="place" action="/places/editPlaces">
    <form:input path="tripId" typ="hidden"/>
    <form:hidden path="id"/>
    <label> New name</label>
    <form:input path="name"/>
    <form:errors path="name"/><br/>
    <label>New location</label>
    <form:input path="location"/>
    <form:errors path="location"/><br/>
    <label>New photo</label>
    <form:input path="photo"/>
    <form:errors path="photo"/><br/>
    <label>New description</label>
    <form:input path="description"/>
    <form:errors path="description"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>


