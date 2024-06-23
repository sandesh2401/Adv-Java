package com.student.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.student.model.StudentModel;
import com.studentDAOImpl.StudentDAOImpl;

/**
 * Servlet implementation class StudentSave
 */

@WebServlet("/StudentSave")
public class StudentSave extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentDAOImpl obj;
	
	public StudentSave() {
		obj = new StudentDAOImpl();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("here 1");
		PrintWriter pw = response.getWriter();
		System.out.println("here 2");
		response.setContentType("text/html");
//		System.out.println("here 3");
		try {
			System.out.println("here 4");
			StudentDAOImpl obj = new StudentDAOImpl();
			List<StudentModel> stdList = obj.getAll();
			if(!stdList.isEmpty()) {
				request.setAttribute("list", stdList);
				request.getRequestDispatcher("list.jsp").forward(request, response);
			}else {
				response.getWriter().println("<h2>Failed..</h2>");
			}
			
		} catch (Exception e) {
			System.out.println("here cat");
			e.printStackTrace();
			response.getWriter().println("<h2>Something Wrong Here..</h2>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("here 2");
		try {
//			System.out.println("here 3");
			StudentModel std = new StudentModel();
//			System.out.println("here 4");
			std.setId(Integer.parseInt(request.getParameter("id")));
//			System.out.println("here 5");
			std.setName(request.getParameter("name"));
//			System.out.println("here 6");
			std.setMarks(Float.parseFloat(request.getParameter("marks")));
//			System.out.println("here 7");
			std.setNum(Integer.parseInt(request.getParameter("num")));
//			System.out.println("here 8");
//			StudentDAOImpl obj = new StudentDAOImpl();
//			System.out.println("here 9");
			
			int rs = obj.save(std);
//			System.out.println("here 10");
			if(rs>0) {
//				System.out.println("here 11");
				request.setAttribute("msg", "Student Registered Successfully..");
//				System.out.println("here 12");

				request.getRequestDispatcher("form.jsp").forward(request, response);
//				System.out.println("here 13");

			}
			else {
//				System.out.println("here 14");

				response.getWriter().println("<h2>Failed..</h2>");
			}
			
		} catch (Exception e) {
			response.getWriter().println("<h2>Something Wrong Here..</h2>");
		}
	}

}
