
<jsp:include page="/WEB-INF/views/Nav.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="blue">
<form:form action="updateRecipe" method="post" modelAttribute="recipe">
<pre>
Id : <form:input type="text" path="id" value="${recipe.id}" />
Category :  <form:select class="custom-select custom-select-sm" v-model="category" path="category" value="${recipe.category }">
   <option selected>All</option>
   <option>Breakfast</option>
   <option>Lunch</option>
   <option>Dinner</option>
 </form:select>
Recipe Title : <form:input type="text" path="title" value="${recipe.title}" />
<form:errors path="title" cssStyle="red" />
Description :  <form:input type="text" path="description" value="${recipe.description}"/>
<form:errors path="description" cssStyle="red" />

 Ingredients : <form:input type="text" path="ingredients" value="${recipe.ingredients}" />
 <form:errors path="ingredients" cssStyle="red" /> 
 Instructions : <form:input type="text" path="instructions" value="${recipe.instructions}" />
 <form:errors path="instructions" cssStyle="red" />
 <input type="submit" value="Update" />
</form:form>
</pre>
</body>
</html>