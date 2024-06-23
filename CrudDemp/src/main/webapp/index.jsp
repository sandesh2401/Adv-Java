<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
</head>
<body>
<form action="StudentController" method="post">
<input type="text" placeholder="Enter ID" name="id">
<br><br>
<input type="text" placeholder="Enter Name" name="name">
<br><br>
<input type="text" placeholder="Enter Phone" name="phone">
<br><br>
<input type="text" placeholder="Enter Marks" name="marks">
<br><br>
<input type="submit" value="Register">
<input type="reset" value="Reset">
<br><br>
<a href="StudentController">List of Students</a>
<%
	if(request.getAttribute("msg") != null) {
	%>
	<h1><%=request.getAttribute("msg") %></h1>
	<% 
	}
	if(request.getAttribute("error") != null) {
	%>
	<h1><%=request.getAttribute("error") %></h1>
	<%
	}
%>
</form>
</body>
</html>