package com.studentmvc.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.studentmvc.daoimpl.StudentDAOImpl;
import com.studentmvc.serviceimpl.StudentServiceImpl;

/**
 * Servlet implementation class StudentDeleteController
 */
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentServiceImpl studentServiceImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteController() {
        studentServiceImpl = new StudentServiceImpl();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				int result = studentServiceImpl.remove(id);
				if(result > 0) {
					printWriter.println("<h1>Student Deleted</h1>");
					response.sendRedirect("StudentController");
					
				}
				else {
					printWriter.println("<h1>Student is Not Deleted</h1>");
				}
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
				printWriter.println("<h1>Something went wrong</h1>");
				
			}
	}

}
