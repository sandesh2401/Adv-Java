<%@page import="com.student.model.StudentModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome Home</h1>
	<%
	if (request.getAttribute("obj") != null) {
		StudentModel std =(StudentModel) request.getAttribute("obj");
	%>
	<form action="UpdateStudent" method="post">
		<input type="text" placeholder="Enter ID" name="id" value="<%=std.getId()%>" readonly="readonly"> <br>
		<br>
		 <input type="text" placeholder="Enter Name" name="name"  value="<%=std.getName()%>">
		<br>
		<br> 
		<input type="text" placeholder="Enter Marks" name="marks" value="<%=std.getMarks()%>">
		<br>
		<br>
		 <input type="text" placeholder="Enter Phone Number" name="num" value="<%=std.getNum()%>"> <br>
		<br> <input type="submit" placeholder="Submit"> 
	</form>
	<%
	}
	%>
	<a href="StudentSave">Show Lit of the Students</a>

</body>
</html>