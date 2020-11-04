<jsp:include page="/WEB-INF/views/Nav.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	var searchCondition='${searchCondition}'
	$('.table').DataTable({
		"lengthMenu":[[5,7,-1],[5,7,"All"]],
	    "oSearch" : {
		"sSearch" : searchCondition
		}
	})
})
 

</script>
</head>
<body background="resources/images/c5.jpg">
<h2 align="center" style="color:black;font-family:Arial Black;">List of Recipes</h2>
 
<div align="center" >
<table class="table table-striped" border="1" bgcolor="white">
			<thead bgcolor="pink">
				<tr>
					<th>Category</th>
					<th>Title</th>
					<th>Description</th>
					<th>Ingredients</th>
					<th>Instructions</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lists }"  var="list" >
					<tr >
						<td>${list.category }</a></td>
						<td>${list.title }</td>
						<td>${list.description }</td>
						<td>${list.ingredients }</td>
						<td>${list.instructions }</td>
						<td>
				            <a href="<c:url value='/deleteRecipe/${list.id }'></c:url>">
				            <span class="glyphicon glyphicon-trash"></span></a> 
								
								<a href="<c:url value='/editRecipe/${list.id }'></c:url>">
								<span class="glyphicon glyphicon-pencil"></span></a>
							</td>
                              
					</tr>
				</c:forEach>
			</tbody>
		</table>

</div>

</body>
</html>