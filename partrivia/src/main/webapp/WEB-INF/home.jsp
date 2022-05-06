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
<title>Home</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="dashHead">
    <div class="d-flex align-items-center">
        <img src="https://clipground.com/images/tees-clipart-16.jpg" alt="logo" class="logo" >
        <h1>Hello <c:out value="${user.firstName}"></c:out> <c:out value="${user.lastName}"></c:out>! </h1>
    </div>
    	<h1 class="title">TrivialParsuit</h1>
        <a href="/logout" class="btnDash btn btn-secondary">Log Out</a>
    </div>
	
    <div class="container mx-auto"> <!-- Beginning of Container -->
    
        <h1 class="welcome">Welcome to TrivialParsuit</h1>
        
        <div class="bodyContentMain">
           <img src="https://th.bing.com/th/id/OIP.I4pOa0jSEHXsSLcywlsmmwHaDk?w=350&h=168&c=7&r=0&o=5&pid=1.7" class="mainImg"/>
           <div class="creator">
              <h1>Created By:</h1>
              <img src="https://abingtonsports.com/images/2020/4/6/Nothdurft.jpg?width=942&quality=80&format=jpg" class="mattImg"/>
           </div>
        </div>
        
        <a href="/starter" class="start btn btn-success btn-lg">Let's meet up with the starter!</a>
        
    </div>
    
    <div>
        <h1 class="about">TrivialParsuit is a golf-themed trivia application that captures who I am <br/> and what I love, so please make sure to keep the drinks cold and have a great time!</h1>
    </div>
    
</body>
</html>