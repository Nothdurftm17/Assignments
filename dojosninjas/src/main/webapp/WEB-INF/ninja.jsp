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
<title>Title Here</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
<h1>Add a Ninja</h1>
    <div class="container"> <!-- Beginning of Container -->
        	<form:form action="/processNinja" method="post" modelAttribute="ninja">
    <p>
        <form:label path="firstName">First Name: </form:label>
        <form:errors class="alert-danger" path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name: </form:label>
        <form:errors class="alert-danger" path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age: </form:label>
        <form:errors class="alert-danger" path="age"/>
        <form:input type="number" path="age"/>
    </p>
    
    <form:select path="dojo" > 
    <c:forEach var="i" items="${allDojos}">
    
    <form:option value="${i.id}">${i.name}</form:option>
    </c:forEach>
    </form:select>
    <input type="submit" value="Submit"/>
</form:form>   
    </div> <!-- End of Container -->
</body>
</html>