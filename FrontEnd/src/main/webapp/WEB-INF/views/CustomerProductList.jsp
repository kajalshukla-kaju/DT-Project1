<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" >
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link type="text/css" rel="stylesheet" href="WEB-INF/CSS/">

</head>
<body>
<%@include file="menu.jsp" %>
<div style="width: 100%; height: 50px;"></div>
<div class="container">
<h2>Product List for Customer</h2>
<table class="table table-hover" id="apl" class="display" style="border: 2px; width: 80px; align:center;">
<tr>
<th> Serial No</th>
<th>PID</th>
<th>Product Name</th>
<th>Product Supplier</th>
<th>Product Category</th>
<th>Description</th>
<th>Stock</th>
<th>Price</th>
<th>Image</th>
<th class="sapn2">Action</th>
</tr>

<c:if test="${empty prList }">
<tr>
<td colspan="10" align="center" >No record exists !!!</td>
</tr>
</c:if>

<c:forEach var="p" varStatus="st" items="$prList">
<tr>
<td><c:out value="${st.count }"></c:out> </td> 
<td><c:out value="${p.productid }"></c:out></td> 
<td><c:out value="${p.productname }" ></c:out></td> 
<td><c:out value="${p.productname }"></c:out></td> 
<td><c:out value="${p.Supplier.suppliername }"></c:out></td> 
<td><c:out value="${p.Category.Categoryname }"></c:out></td> 
<td class="span3"><c:out value="${p.description }"></c:out></td> 
<td><c:out value="${p.stock }"></c:out></td> 
<td><c:out value="${p.price }"></c:out></td> 
<td><img alt="" src="${pageContext.request.contextPath}/WEB-INF/image/${p.imgname}" height="50px" width="50px"></td>
<td class="span2">
<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
<a class="btn btn-info" role="button" href='<c:url value="/proudDetails?productid=${p.productid }"></c:url>'>Details </a>

</td>
</tr>

</c:forEach>
</table>


</div>
</body>
</html>