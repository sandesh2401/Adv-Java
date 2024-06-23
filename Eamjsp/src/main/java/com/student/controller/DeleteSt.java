package com.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.studentDAOImpl.StudentDAOImpl;

/**
 * Servlet implementation class DeleteSt
 */
public class DeleteSt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAOImpl obj;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteSt() {
    	obj = new StudentDAOImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			int result = obj.remove(id);
			if(result>0) {
				printWriter.println("<h3>Student deleted</h3>");
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
