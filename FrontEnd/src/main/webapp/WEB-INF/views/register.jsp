<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta content="width=device-width , initial-scale=1" name="viewport" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Registration Page</title>
<style type="text/css">
body{
font-family: serif;}
form {
	margin-top: 40px;
	color: silver;}
	*{box-sizing: border-box}
	input[type=text], input[type=password] {
	width: 100%;
	padding-left: 15px;
	padding-bottom:15px;
	padding-right: 6px;
	padding-top: 6px;
	margin: 6px 1px 23px 1px;
	display: inline-block;
	border: thin;
	background: #; 
}

input[type=text], input[type=password]:focus {
	background-color:gray;
	outline: silver; 
}
hr {
	border: 1px solid gray;
	margin-bottom: 25px;
}
button {
	background-color: green;
	color: white;
	padding: 15px 21px;
	margin: 9px 1px;
	border: 1px;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}
button:hover {
opacity: 1px;
font-size: 30px;
}
.cancelbtn{
padding: 14px 20px;
background-color: red;
}
.cancelbtn,.signupbtn{
float:left;
width: 50%;
} 
.container{
padding: 16px;
background: ghostwhite;
box-shadow: 1px 1px 18px -3px;
border: 1px  solid : white;
}
.clearfix::after {
	content: "";
	clear: both;
	display: table; 
}
@media screen and (max-width:300px) {
.cancelbtn, .signupbtn{
width: 100%;
}
	}
</style>
</head>
<body>
<%@ include file="menu.jsp" %>
<form:form modelAttribute="user" action="saveRegister" method="post">
<div class="container">
<h1>Sign Up</h1>
<p>Please fill this Form to create new account.</p>
<hr>

<div class="form-group">
<label>Name</label>
<form:input path="name" type="text" class="form-control" placeholder="Enter name" name="name" required="true"/>
</div>

<div class="form-group">
<label>Email</label>
<form:input path="email" type="email" class="form-control" placeholder="Enter EmailId" name="email" required="true"/> 
</div>

<div class="form-group">
<label>Password</label>
<form:input path="password" type="password" class="form-control" placeholder="Enter password" nmae="pass" required="true"/>
</div>

<div class="form-group">
<label>Address</label>
<form:input path="address" type="text" class="form-control" placeholder="Enter Address" name="address" required="true"/>
</div>

<div class="form-group">
<label>Phone</label>
<form:input path="phone" type="number" class="form-control" placeholder="Enter phone number" name="phone" required="true" />
</div>

<p> By creating an account you agree to our<a href="#" style="color: voiletblue">Terms and Condition</a></p>

<div class="clearfix">
<button type="reset" class="cancelbtn">Cancel</button>
<button type="submit" class="signupbtn">Sign Up</button>
</div>
</div>
</form:form>
<%@include file="footer.jsp" %>

</body>
</html>