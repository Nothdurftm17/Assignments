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
        <h1>Save Travels</h1>
        
        <table class="table table-dark table-striped">
  <thead>
    <tr>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      <th scope="col">Actions</th>
      
    </tr>
  </thead>
  <tbody>
    <c:forEach var="i" items="${allExpenses}">
    <tr>
      <td><a href="/oneExpense/${i.id}"><c:out value="${i.name}"></c:out></a></td>
      <td><c:out value="${i.vendor}"></c:out></td>
      <td><c:out value="$ ${i.amount}"></c:out></td>
      <td>
      <a class="btn btn-primary" href="/updateExpense/${i.id}">Update</a>
      <a class="btn btn-danger" href="/delete/${i.id}">Delete</a>
      </td>
    </tr>
  	</c:forEach>
  </tbody>
</table>
<br>       
<br>   
<br>
<br>   
 <!-- Form--------------------------------------------->
 <div class="create text-center">
 <h2>Add an Expense:</h2>
        <form:form action="/processExpense" method="post" modelAttribute="expense" class="form">
    <p>
        <form:label path="name">Expense Name: </form:label>
        <form:errors class="alert-danger" path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor: </form:label>
        <form:errors class="alert-danger" path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount: </form:label>
        <form:errors class="alert-danger" path="amount"/>
        <form:input type="double" step="0.01" min="0.01" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description: </form:label>
        <form:errors class="alert-danger" path="description"/>     
        <form:textarea col="3" row="10" path="description"/>
    </p>   
    
    <input type="submit" value="Submit" class="btn btn-success btn-large"/>
</form:form>   
 </div>
    </div> <!-- End of Container -->
</body>
</html>