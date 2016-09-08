<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="<c:url value="/resources/admin.css"/>">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>category page</title>
</head>
<body>
${msg}
	<h1>Add a Category</h1>
	<c:url var="addAction" value="/category/add"></c:url>
	<form:form action="${addAction}" command name="category">
	 <table>
	 <tr>
	 <td><form:label path="id"><spring:message text="ID"/></form:label></td>
	 <c:choose>
	 <c:when test="${!empty category.id }">
	 <td><form:input path="id" disabled="true" readonly="true"/></td>
	 </c:when>
	 <c:otherwise>
	 <td><form:input path="id" pattern=".{4,7}" required="true" title="id should contains 4 to 7 characters"/></td>
	 </c:otherwise>
	 </c:choose>
	 <tr>
	 <td><form:label path="name"><spring:message text="Name"/></form:label></td>
	 <td><form:input path="name" required="true"/></td>
	 </tr>
	 <tr>
	 <td><form:label path="description"><spring:message text="Description"/></form:label></td>
	 <td><form:input path="description" required="true"/></td>
	 </tr>
	 <tr>
	 <td colspan="2"><c:if test="${!empty category.name }">
	 <input type="submit" value="<spring:message text="edit category"/>"/>
	 </c:if><c:if test="${empty category.name}">
	 <input type="submit" value="<spring:message text="add category"/>"/>
	 </c:if></td>
	 </tr>
	 </table>
	 </form:form>
	 <br>
	 <h3>Category list</h3>
	 <c:if test="${!empty categoryList}">
	 <table class="tg">
	 <tr>
	 <th width="80">category id</th>
	 <th width="120">category name</th>
	 <th width="120">category Description</th>
	 <th width="60">Edit</th>
	 <th width="60">delete</th>
	 </tr>
	 <c:forEach items="${categoryList} var="category">
	 <tr>
	 <td>${category.id}</td>
	 <td>${category.name}</td>
	 <td>${category.description}</td>
	 <td><a href="<c:url value='category/edit/${category.id}'/>">edit</a></td>
	 <td><a href="<c:url value='category/remove/${category.id}'/>">delete</a></td>
	 </tr>
	 </c:forEach>
	 </table>
	 </c:if>
</body>
</html>