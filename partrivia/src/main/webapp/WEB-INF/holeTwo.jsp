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
<title>Hole #2</title>
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
<div class="holeOneContainer">

    <h1 class="holeNum">Hole #2</h1>
    <div class="qBox">
    <div class="stat">
	<p class="stats">Correct Answers: ${cCount}</p>
	<p class="stats"> Answers Left: ${aLeft}</p>
    </div>

	<h4>${wrong}</h4> <h4>${success}</h4>
	
    	<h1 class="questionForm"><c:out value="${questionTwo}"></c:out></h1>
    	
 <form action="/checkTwo" method="post" class="questionForm" >
  <div class="form-check m-2">
 
  <input class="form-check-input" type="radio" name="answer" value="Correct">
  <label class="qInputs form-check-label">
    ${answerOne}
  </label>
</div>

<div class="form-check m-2">
  <input class="form-check-input" type="radio" name="answer" value="${answerTwo}">
  <label class="qInputs form-check-label">
    ${answerTwo}
  </label>
</div>

<div class="form-check m-2">
  <input class="form-check-input" type="radio" name="answer" value="${answerThree}">
  <label class="qInputs form-check-label">
    ${answerThree}
  </label>
</div>

<div class="form-check m-2">
  <input class="form-check-input" type="radio" name="answer" value="${answerFour}">
  <label class="qInputs form-check-label">
    ${answerFour}
  </label>
</div>

  	<br>
    	<input type="submit" value="Submit" class="qSubmit btn btn-secondary btn-lg">
    	</form>
</div>
<a href="/home" class="btn btn-success btn-lg my-5"> Home </a>
</div>
</body>
</html>