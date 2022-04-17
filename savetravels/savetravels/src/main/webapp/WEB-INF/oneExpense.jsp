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
<title>Expenses</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container"> <!-- Beginning of Container -->
         <a href="/" class="btn btn-secondary">Home</a>
 <br>
 <br>
        <h1><c:out value="${expense.name}"></c:out></h1>
        
        <table class="table table-dark table-striped">
  <thead>
    <tr>
    
      <th scope="col"><h3>Information:</h3></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><h4>Vendor: <c:out value="${expense.vendor}"></c:out></h4></td>
    </tr>
    <tr>
      <td><h4>Amount: <c:out value="$ ${expense.amount}"></c:out></h4></td>
    </tr>
    <tr>
      <td><h4>Description: <c:out value="${expense.description}"></c:out></h4></td>
    </tr>
    </tr>

  </tbody>
</table>
    </div> <!-- End of Container -->
</body>
</html>