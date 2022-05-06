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
<title>Login</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="containerLogReg"> <!-- Beginning of Container -->
<div class="register">
<div class="reg">
<h1>Registration</h1>

<form:form action="/register" method="post" modelAttribute="newUser">
                <div class=" regInfo form-group">
                    <label>First Name:</label>
                    <form:input path="firstName" class="input form-control" />
                </div>
                <div class="regInfo form-group">
                    <label>Last Name:</label>
                    <form:input path="lastName" class="input  form-control" />
                </div>
                <div class="regInfo form-group">
                    <label>Email:</label>
                    <form:input path="email" class="input form-control" />
                </div>
                <div class="regInfo form-group">
                    <label>Password:</label>
                    <form:password path="password" class="input form-control" />
                </div>
                <div class="regInfo form-group">
                    <label>Confirm Password:</label>
                    <form:password path="confirm" class="input form-control" />
                </div>
                <input type="submit" value="Register" class="btn btn-success btn-lg my-5" />
                    <br>
                    <form:errors path="firstName" class="text-danger" style="font-size: 25px"/>
                    <br>
                    <form:errors path="lastName" class="text-danger" style="font-size: 25px"/>
                    <br>
                    <form:errors path="email" class="text-danger" style="font-size: 25px"/>
                    <br>
                    <form:errors path="password" class="text-danger" style="font-size: 25px"/>
                    <br>
                    <form:errors path="confirm" class="text-danger" style="font-size: 25px"/>
            </form:form>
</div>
            </div>
            
            
            
            <div class="login col-4">
    <div class="parsuit"><h1 class="titleLogA">Trivial</h1><h1 class="titleLogB">Parsuit</h1></div>
            <h1 class="font">Login:</h1>
            <form:form action="/login" method="post" modelAttribute="newLogin">
                <div class=" logInfo form-group">
                    <label class="font">Email:</label>
                    <form:input path="email" class="input form-control" />
                </div>
                <div class="logInfo form-group">
                    <label class="font">Password:</label>
                    <form:password path="password" class="form-control" />
                </div>
                <input type="submit" value="Login" class="btn btn-success btn-lg my-5" />
                <form:errors path="email" class="text-danger" style="font-size: 25px"/>
                <br>
                <form:errors path="password" class="text-danger" style="font-size: 25px"/>
        </form:form>
        </div>
    </div> <!-- End of Container -->
</body>
</html>