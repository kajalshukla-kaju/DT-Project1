<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" http-equiv="Content-Type" content="text/html">
<meta name="viewport" content="width=device-width , initial-scale=1" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link rel="stylesheet" href="${CSS}/lgnreg.css">

  <title>Home Town</title>
  <style type="text/css">
  form{border: 3px solid blueviolet;}
  input[type=text], [type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
    min-width: 200px;
}
button:hover {
    opacity: 0.8;
}
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
    float:left;
}
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    width:300px;
    height:89px;
}
img.avatar {
    width: 40%;
    border-radius: 50%;
}
.container {
    padding: 16px;
    box-shadow: 0px 0px 18px -3px;
}
span.psw {
    float: right;
    padding-top: 16px;
}
/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
  
  </style>
</head>
<body>
<%@include file="menu.jsp" %>
<form:form name="Submit Form" action="${pageContext.request.contextPath }/login" method="POST" >
<div align="center" style="margin-top: 70px">
<div class="imgContainer">
<img alt="profile" src=""  class="avatar">
</div>
</div>
<div class="container" style="min-width: 450px; max-width: 100%;width: 660px;" >
<label><b>User Name</b></label>
<input type="text" placeholder="enter name" name="username" required="required">

<label><b>Password</b></label>
<input type="password" placeholder="enter password" name="pass" required="required">

<label>
<input type="checkbox" checked="checked" >Remember Me !!
</label>

<button type="submit">Login</button>
</div>
<div class="container" style="background-color:#f1f1f1; min-width: 450px; max-width: 100%; width:660px;">
<button type="reset" class="cancelbtn">Reset</button>
<span class="psw">Forgot <a href="#" >password?</a></span> 
</div>

</form:form>
<%@include file="footer.jsp" %>
</body>
</html>