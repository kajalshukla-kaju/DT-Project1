<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width , initial-scale=1" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link type="text/css" rel="stylesheet" href="/WEB-INF/CSS/" >

</head>
<body>
<%@include file="menu.jsp" %>
<div style="width: 100%; height: 50px;"></div>
<div class="container">
<div class="row">
<div class="col-sm-4 item-photo">
<img  style="max-width: 100%; margin-top:30px; " alt="pro" src="${pageContext.request.contextPath }/WEB-INF/image/${prod.imgName}"/>
</div>
<div class="col-sm-5" style="border: 1px solid grey; margin-top:90px; ">
<h3>${prod.productname}</h3>
<h4>${prod.description}</h4>
<h4>${prod.price }</h4>
<h5>${prod.Supplier.suppliername}</h5>
<div class="selection" style="padding-bottom: 20px">
<form action="${pageContext.request.contextPath }/addToCart" method="post">
<input type="hidden" value="${prod.productid }" name="productid"/>
<input type="hidden" value="${prod.productname }" name="productname"/>
<input type="hidden" value="${prod.price }" name="pPrice"/>
<input type="hidden" value="${prod.imgName }" name="imgName"/>
<input type="text" class="form-control" placeholder="Quantity"  name="pqty" required="required"/>
<input class="btn btn-warning btn-lg"  type="submit" value="Add To Cart" />
<h6><span class="glyphicon-heart-empty" style="cursor: pointer;">Wish List</span></h6>

</form>
</div>
</div>

<hr>
<div class="col-sm-9">
<h3>Product Details</h3>
<ul class="menu-Items">
<li>Checked Quality</li>
<li>Easy Return</li>
<li>Money Back Guarantee</li>
</ul>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>