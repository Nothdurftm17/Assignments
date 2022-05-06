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
<title>Starter</title>
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
	
    <div class="containerStarter"> <!-- Beginning of Container -->
    <div class="topTier">
        <div class="greeting">
        <h1 class="before">Before you start your round,</h1>
        <!-- <h1 class="rules">Rules are as follows: <br/> You start on the tee and do not advance until  <br/> either 4 questions are answered correctly or <br/> you reach the stroke limit(8). After the three holes, <br/> total the score and see how you stand against the competition!</h1> -->
        <h1 class="rules">Rules are as follows: <br/> You start on the first tee <br> and head back to the club house <br>after the third hole and see <br>how you scored!
        </div>
        <div >
        <img alt="Tiger Woods" src="https://img.bleacherreport.net/img/images/photos/003/636/330/hi-res-ccbaf4318e7959719c4a0d07fd3a7e28_crop_exact.jpg?w=1200&h=1200&q=75" class="tiger">
        <h4 class="goat">The Greatest of All Time: Tiger Woods</h4>
        </div>
    </div >
    <div class="flag">
        <a href="/holeOne" class="play btn btn-success">HEAD TO THE FIRST TEE</a>
        <div class="pole"></div>
    </div >
    </div> <!-- End of Container -->
</body>
</html>