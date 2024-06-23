<%@page import="java.util.Iterator"%>
<%@page import="com.productmvc.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<Product> products = (ArrayList<Product>)request.getAttribute("list");
	Iterator<Product> itr = products.iterator();
	while(itr.hasNext()) {
		Product p = itr.next();
		
		%>
		<p>Id: <%=p.getId() %>, Name: <%=p.getName() %>,
		Price: Rs.<%=p.getPrice() %>, Qty: <%=p.getQty() %>,
		<a href="remove-product/<%=p.getId() %>">Delete</a></p>
		<% 
	}
%>
</body>
</html>