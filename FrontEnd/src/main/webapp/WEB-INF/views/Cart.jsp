<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link type="text/css" rel="stylesheet" href="/resources/nav.css" >
<title>Home Page</title>
<style type="text/css">
.container{
min-height:500px ;
min-width: 100%;
}
</style> 
</head>
<body>
<%@include file="menu.jsp" %>
<div style="width: 100%; height:50px;"></div>
<div class="container">
<table class="table table-hover" id="apl" class="display" style="border: 2px; width:80px; align:center;" >
<tr>
<th>Product Name</th>
<th>Product Quantity</th>
<th>Product Price</th>
<th>Product Image</th>
<th>Sub-Total</th>
<th class="span2">Action</th>
</tr>
<c:if test="${empty cartInfo }">
<tr>
<td colspan="10" align="center" >No record exists !!!</td>
</tr>
</c:if>

<c:forEach var="p" varStatus="st" items="$cartInfo">
<tr>
<td><c:out value="${p.cartProductName }"></c:out></td>
<td><c:out value="${p.cartStock }"></c:out></td>
<td><span class="fa fa-rupee"></span><c:out value="${p.cartPrice}"></c:out></td>
<td><img src="${pageContext.request.contextPath}/assets/images/${p.cartImage}" height="50" width="50"></td>
<td><span class="fa fa-rupee"></span><c:out value="${p.cartStock*p.cartPrice  }"></c:out></td>
<td class = "span2">
<c:set var = "contextRoot" value = "${pageContext.request.contextPath }"></c:set>
<a class = "btn btn-danger" role = "button" href = "<c:url value="/deletePCart/${p.cartId }" />">Delete</a>
</td>
</tr>
<c:set var = "gtot" value = "${gtot+ p.cartPrice*p.cartStock }"></c:set>
</c:forEach>

<tr>
<td align="right" colspan="6">
<span class = "col-lg-9" align = "right"><b>Grand Total: </b><b><span class="fa fa-rupee"></span><c:out value="${gtot  }"></c:out></b></span>
</td>
</tr>

<tfoot>
<tr>
<td>
<a class = "btn btn-warning btn-lg" href = "${pageContext.request.contextPath }/index">Continue shopping</a>
</td>
<td colspan="5">
<a class = "btn btn-success btn-lg" style="float: right;" href = "${pageContext.request.contextPath }/checkout">Checkout</a>
</td>
</tr>
</tfoot>
</table>
</div>

<%@include file="footer.jsp" %>
</body>
</html>