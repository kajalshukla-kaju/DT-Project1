<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width , initial-scale=1">
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="/WEB-INF/CSS/">

</head>
<body>
<%@ include file="menu.jsp" %>
<div style="width: 100%; height: 50px;"></div>
<div class="container">
<h2>Supplier List For Admin</h2>

<table class="table table-hover" id="apl" class="display" style=" border: 2px; width: 80px; align:center; " >
<tr>
<th>Serial No</th>
<th>SID</th>
<th>Supplier Name</th>

<th class="span2">Action</th></tr>

<c:if test="${empty satList}">
<tr>
<td colspan="10" align="center">No record exist !!</td>
</tr>
</c:if> 

<c:forEach var="p" varStatus="st" items="${satList}">
<tr>
<td><c:out value="${st.count }"></c:out></td>
<td><c:out value="${p.sid }"></c:out></td>
<td><c:out value="${p.suppliername }"></c:out></td>

<td class="span4">

<c:set var="contextRoot" value="${pageContext.request.contextPath }"></c:set>
<a class="btn btn-info" role="button" href="#">Edit</a>
<a class="btn btn-danger" role="button" href="#">Delete</a>
</td> </tr>

</c:forEach>
</table>
</div>

</body>
</html>