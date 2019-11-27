<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width , initial-scale=1" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link type="text/css" rel="stylesheet" href="/WEB-INF/CSS/" >
  <style type="text/css">
  .container{azimuth: 
   padding:6px;
   background-color:#fdfffd;
   box-shadow: 2px 1px 2px 1px;
   border: 1px solid silver;
   min-height: 450px; 

  
  }
  
  
  </style>
  

</head>
<body>
	<%@ include file="menu.jsp"  %>
	<div style="width: 100%; height: 50px;"></div>

<div class="container">
<c:url value="/ProductUpdate " var="p"></c:url>
<h1 class="input-title">Update Product</h1>
<hr>
<form method="post"  action="${pageContext.request.contextPath }/admin/ProductUpdate" class="form-signin" enctype="multipart/ form-data">
<span id="reauth-email" class="reauth-email"></span>
<input type="hidden" name="productId" value="${prod.productid }">
<h4 class="input-title">Product Name</h4><br>
 <input class="form-control" value="${prod.productname }" type="text" name="productName" required="required"/><br>
 
 <h4 class="input-title"> Product Description</h4><br>
 <input class="form-controller" value="${prod.description }" type="text" name="description" required="required"/><br>
 
 <h4 class="input-title">Product Price</h4>
 <input class="form-control" value="${prod.price }" name="price" type="text" required="required" /><br>
 
 <h4 class="input-title">Product Stock</h4>
 <input class="form-controller" value="${prod.stock }" type="text" name="stock" required="required"/><br>
 
<div class="form-group">
<table>
<tr>
<th>Select Supplier</th>
<td>
<select class="form-control" name="pSupplier" required="required">

<option value=" ">--Select Supplier--</option>
<c:forEach items="${sList }" var="sat">
<option value="${sat.sid }">${sat.suppliername}</option>
</c:forEach>

</select></td>
</tr>

</table>
</div>
  
<div class="form-group">
<table>
<tr>
<th> Select Category</th>
<td>
<select class="form-control" name="pCategory" required="required">
<option value=" ">--Select Category--</option>
<c:forEach items="${cList }" var="car">
<option value="${car.cartid}">${car.Categoryname}</option>
</c:forEach>

</select></td></tr>

</table>

</div>
<div class="fileinput fileinput-new" data-provider="fileinput">

<td>Product Image</td>
<td><input class="form-control" type="file" name="file" accept="image/*"></td>

</div>

<br><br>
<button class="btn  btn-lg btn primary" type="submit">Update</button>
<button class="btn btn-lg btn Warning" type="reset">Cancel</button>



</form>


</div>

</body>
</html>