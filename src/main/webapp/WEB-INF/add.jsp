<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Trip add</title>
</head>
<body>

<form:form method="post"
           modelAttribute="trips">
    <label>Name</label>
    <form:input path="name"/>
    <form:errors path="name"/><br/>
    <label>startDate</label>
    <form:input type="date" path="startDate" pattern="yyyy-MM-dd"/>
    <form:errors path="startDate"/><br/>
    <label>endDate</label>
    <form:input type="date" path="endDate" pattern="yyyy-MM-dd"/>
    <form:errors path="endDate"/><br/>
    <label>description</label>
    <form:input path="description"/>
    <form:errors path="description"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>


