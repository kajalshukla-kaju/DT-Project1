<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.jsp"  %>
<div style="width: 100%; height: 50px;"></div>

<div class="container">


                    <div style="float: right" >
                    <form action="" method="post">
                        Name: <br><br><input type="text" name="name"/>
                         <input type="text" name="name"/><br><br><br>
                        <label for="email">Email Address:<br><br><input type="text" name="email" height="30px" placeholder="enter a valid email address"/></label><br><br><br>
                         Subject:<br><br><input type="text" name="sub" height="30px"/><br><br><br>
                            Message:<br><br><br><textarea  name="comment" height="40px" >enter comment here.....</textarea>
                        <br> <br><input type="button" style="background-color: black;color: beige" value="SUBMIT">
</form></div>

</div>
<%@include file="footer.jsp" %>
</body>
</html>