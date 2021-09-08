<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Trip add</title>
</head>
<body>

<form:form method="post" modelAttribute="trip" action="/trip/edit">
    <form:hidden path="id"/>
    <label> New name</label>
    <form:input path="name"/>
    <form:errors path="name"/><br/>
    <label>New startDate</label>
    <form:input path="startDate"/>
    <form:errors path="startDate"/><br/>
    <label>New endDate</label>
    <form:input path="endDate"/>
    <form:errors path="endDate"/><br/>
    <label>New description</label>
    <form:input path="description"/>
    <form:errors path="description"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>


