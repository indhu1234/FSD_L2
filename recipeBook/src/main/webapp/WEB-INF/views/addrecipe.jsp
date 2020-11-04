
<jsp:include page="/WEB-INF/views/Nav.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="resources/images/c2.jpg">
<h1>Add Recipe</h1>
<form:form action="addRecipe" method="post" modelAttribute="recipe">
<div align="center"><table bgcolor="white">
<tr><td>
Enter Recipe Title : <form:input type="text" path="title" />
<form:errors path="title" cssStyle="red" /></td></tr>
<tr><td>Enter Description :  <form:input type="text" path="description" />
<form:errors path="description" cssStyle="red" /></td></tr>
</tr><td>Choose Category :  <form:select class="custom-select custom-select-sm" v-model="category" path="category">
   <option selected>All</option>
   <option>Breakfast</option>
   <option>Lunch</option>
   <option>Dinner</option>
 </form:select></td></tr>
<tr><td> Enter ingredients : <form:input type="text" path="ingredients" />
 <form:errors path="ingredients" cssStyle="red" /> </td></tr>
<tr><td> Give Instructions : <form:input type="text" path="instructions" />
 <form:errors path="instructions" cssStyle="red" /></td></tr>
<tr><td rowspan="3"> <input type="submit" value="Add Item" /></td></tr>
</form:form>
</table>
</div>
</body>
</html>