<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Place add</title>
</head>
<body>

<form:form method="post" modelAttribute="place">
    <label>Name</label>
    <form:input path="name"/>
    <form:errors path="name"/><br/>
    <label>location</label>
    <form:input path="location"/>
    <form:errors path="location"/><br/>
    <label>photo</label>
    <form:input path="photo"/>
    <form:errors path="photo"/><br/>
    <label>description</label>
    <form:input path="description"/>
    <form:errors path="description"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>


