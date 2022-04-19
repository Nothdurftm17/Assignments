<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
        <h1>Welcome <c:out value="${user.firstName}"></c:out> <c:out value="${user.lastName}"></c:out>!</h1>
        
        <a href="/plants/new" class="btn btn-success">Add a Plant</a>
        <a href="/logout" class="btn btn-secondary btn-large">Log Out</a>
        
  <table class="table table-dark table-striped">
  <thead>
    <tr>
      <th scope="col">Flower:</th>
      <th scope="col">Schedule:</th>
      <th scope="col">Posted By:</th>
      <th scope="col">Actions: </th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="plant" items="${allPlants}">
  	<c:choose>
  	<c:when test="${user.id == plant.user.id }">
  	<tr>
      <td><a href="/onePlant/${plant.id}"><c:out value="${plant.name}"></c:out></a></td>
      <td><c:out value="${plant.schedule}"></c:out></td>
      <td><c:out value="${plant.user.firstName}"></c:out></td>
      <td>
      <a href="/plants/edit/${plant.id}" class="btn btn-primary">Update</a>
      <a href="/deletePlant/${plant.id}" class="btn btn-danger">Delete</a>
      </td>
    </tr>
  	</c:when>
  	<c:otherwise>

  	 <tr>
      <td><a href="/onePlant/${plant.id}"><c:out value="${plant.name}"></c:out></a></td>
      <td><c:out value="${plant.schedule}"></c:out></td>
      <td><c:out value="${plant.user.firstName}"></c:out></td>
      <td></td>
    </tr>
  	</c:otherwise>
  	</c:choose>
   </c:forEach> 
  </tbody>
</table>
    </div> <!-- End of Container -->
</body>
</html>
