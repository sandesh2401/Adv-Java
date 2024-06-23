package com.studentcrud.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.studentcrud.daoimpl.StudentDAOImpl;
import com.studentcrud.models.Student;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentDAOImpl studentDAOImpl;
	
	public StudentController() {
		studentDAOImpl = new StudentDAOImpl();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try {
			List<Student> studentsList = studentDAOImpl.getAll();
			printWriter.println("<table border='1' cellspacing='0' cellpadding='10'>");
			printWriter.println("<tr>");
			printWriter.println("<th>Id</th>");
			printWriter.println("<th>Name</th>");
			printWriter.println("<th>Phone</th>");
			printWriter.println("<th>Marks</th>");
			printWriter.println("<th>City</th>");
			printWriter.println("<th>Gender</th>");
			printWriter.println("<th>Actions</th>");
			printWriter.println("</tr>");
			
			Iterator<Student> studentIterator = studentsList.iterator();
			while(studentIterator.hasNext()) {
				Student student = studentIterator.next();
				printWriter.println("<tr>");
				printWriter.println("<td>"+student.getId()+"</td>");
				printWriter.println("<td>"+student.getName()+"</td>");
				printWriter.println("<td>"+student.getPhone()+"</td>");
				printWriter.println("<td>"+student.getMarks()+"</td>");
				printWriter.println("<td>"+student.getCity()+"</td>");
				printWriter.println("<td>"+student.getGender()+"</td>");
				printWriter.println("<td><a href='DeleteStudentController?id="+student.getId()+"'>Delete</a></td>");
				printWriter.println("<tr>");
			}
			
			printWriter.println("</table>");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			printWriter.println("<h3>Something went wrong...</h3>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try {
			Student student = new Student();
			student.setId(Integer.parseInt(request.getParameter("id")));
			student.setName(request.getParameter("name"));
			student.setPhone(request.getParameter("phone"));
			student.setCity(request.getParameter("city"));
			student.setGender(request.getParameter("gender"));
			student.setMarks(Float.parseFloat(request.getParameter("marks")));
			
			int result = studentDAOImpl.save(student);
			if(result>0) {
				printWriter.println("<h3>Student Registered</h3>");
			}
			else {
				printWriter.println("<h3>Student registration failed</h3>");
			}
			
		} catch (Exception e) {
			System.out.println(e);
			printWriter.println("<h3>Something went wrong...</h3>");
		}
	}

}
