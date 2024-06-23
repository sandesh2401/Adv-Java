<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.studentmvc.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	request.getSession(false);
    %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  </head>
  <body>
    <div class="container">
    	<div class="alert alert-primary" role="alert">
  			List of all the students
		</div>
    </div>
    <div class="container mt-5">
    	<%
    	
    		if(request.getAttribute("studentsList")!=null){
    			List<Student> students =(ArrayList<Student>)request.getAttribute("studentsList");
    			%>
    			<table class="table">
  					<thead>
    					<tr>
      						<th scope="col">Id</th>
      						<th scope="col">Name</th>
      						<th scope="col">Phone</th>
      						<th scope="col">Marks</th>
      						<th scope="col">City</th>
      						<th scope="col">Gender</th>
      						<th scope="col">Actions</th>
    					</tr>
  					</thead>
  					<tbody>
  						<%
  						   Iterator<Student> itr = students.iterator();
  						    while(itr.hasNext()){
  						    	Student s = itr.next();
  						    	%>
  						    	<tr>
  						    		<td><%= s.getId() %></td>
  						    		<td><%= s.getName() %></td>
  						    		<td><%= s.getPhone() %></td>
  						    		<td><%= s.getMarks() %></td>
  						    		<td><%= s.getCity() %></td>
  						    		<td><%= s.getGender() %></td>
  						    		<td><a href='StudentUpdateController?id=<%= s.getId() %>' class="btn btn-success">Update</a></td>
  						    		<td><a href='StudentDeleteController?id=<%=s.getId() %>' class="btn btn-danger">Delete</a></td>
  						    	</tr>
  						    	<% 
  						    }
  						%>
  					</tbody>
  				</table>
    			<%
    		}
    	
    	%>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  </body>
</html>