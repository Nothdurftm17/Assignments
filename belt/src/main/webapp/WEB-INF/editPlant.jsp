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
<title>Edit</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
              <h1>Edit Plant</h1>
              
        <br>
        <a href="/dashboard" class="btn btn-secondary">Home</a>
        <br>
      
        <form:form action="/updatingPlant/${plant.id}" method="post" modelAttribute="plant">
        <input type="hidden" name="_method" value="put"/>
    <p>
        <form:label path="name">Name: </form:label>
        <form:errors class="alert-danger" path="name"/>
        <form:input path="name"/>
    </p>
    
    <p>
        <form:label path="schedule">Schedule: </form:label>
        <form:errors class="alert-danger" path="schedule"/>
        <form:input path="schedule"/>
    </p>
    
    <p>
        <form:label path="description">Description:</form:label>
        <form:errors class="alert-danger" path="description"/>
        <form:textarea col="3" row="10" path="description"/>
    </p>
    
    <input type="submit" value="Submit"/>
</form:form> 
    </div> <!-- End of Container -->
</body>
</html>
