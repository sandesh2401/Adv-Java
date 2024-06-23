<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
</head>
<body>
<h1>Update form for Student</h1>
<form action="UpdateStudent" method="post">
<input type="text" placeholder="Enter ID" name="id" value="${student.id }" >
<br><br>
<input type="text" placeholder="Enter Name" name="name" value="${student.name }">
<br><br>
<input type="text" placeholder="Enter Phone" name="phone" value="${student.phone }">
<br><br>
<input type="text" placeholder="Enter Marks" name="marks" value="${student.marks }">
<br><br>
<input type="submit" value="Update">
<input type="reset" value="Reset">
</form>
<%
	if(request.getAttribute("msg") != null) {
	%>
	<h3><%=request.getAttribute("msg") %></h3>
	<%
	}
	if(request.getAttribute("error") != null) {
	%>
	<h3><%= request.getAttribute("error") %></h3>
	<%
	}
%>
</body>
</html>