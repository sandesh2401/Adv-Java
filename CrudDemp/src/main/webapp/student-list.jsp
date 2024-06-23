<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cruddemo.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>
<h1>Student List</h1>
<% 
	if(request.getAttribute("studentsList") != null) {
	List<Student> students = (ArrayList<Student>)request.getAttribute("studentsList");
	%>
	<table border="1" cellspacing="0" cellpadding="10">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>PHONE</th>
		<th>MARKS</th>
		<th>ACTIONS</th>
	</tr>
	<%
		Iterator<Student> itr = students.iterator();
		while(itr.hasNext()) {
			Student std = itr.next();
			%>
			<tr>
				<td><%=std.getId() %></td>
				<td><%=std.getName() %></td>
				<td><%=std.getPhone() %></td>
				<td><%=std.getMarks() %></td>
				<td><a href="UpdateStudent?id=<%=std.getId()%>">Update</a></td>
				<td><a href="DeleteStudent?id=<%=std.getId()%>">Delete</a></td>
			</tr>
			<%
		}
	%>
	</table>
	<%
	}
%>
</body>
</html>