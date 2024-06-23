package com.studentcrud.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.studentcrud.daoimpl.StudentDAOImpl;

/**
 * Servlet implementation class DeleteStudentController
 */
public class DeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAOImpl studentDAOImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudentController() {
        super();
        studentDAOImpl = new StudentDAOImpl();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			int result = studentDAOImpl.remove(id);
			if(result>0) {
				printWriter.println("<h3>Student deleted</h3>");
				response.sendRedirect("StudentController");
			}
			else {
				printWriter.println("<h3>Problem in deletion</h3>");
			}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			printWriter.println("<h3>Something went wrong...</h3>");
		}
	}

}
