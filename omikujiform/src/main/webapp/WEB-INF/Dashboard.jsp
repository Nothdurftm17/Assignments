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
<title>DashBoard</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container text-center" > <!-- Beginning of Container -->
    <h1>Send An Omikuji!</h1>
    <form action="/omikuji/show" class="form" method="post">
   
    <label>Pick any number from 5 to 25</label>    
    <input type="number" name="number" value="5"/>
    
    
    <label>Enter the name of any real person.</label>    
    <input type="text" name="person" placeholder="Enter a name"/>
    
    
    <label>Enter the name of any city.</label>    
    <input type="text" name="city" placeholder="Enter a city"/>
    
    
    <label>Enter professional endeavor or hobby:</label>    
    <input type="text" name="hobby" placeholder="Enter a hobby"/>
    
    
    <label>Enter any type of living thing.</label>
    <input type="text" name="living" placeholder="Enter a living thing"/>
    
    
    <label>Say something nice to someone.</label>
    <textarea name="nice" col="3" row="10" placeholder="Be nice!"> </textarea>
    
    
    <input type="submit" class="btn btn-success btn-lg my-2"/>
    
    </form>
       
    </div> <!-- End of Container -->
</body>
</html>