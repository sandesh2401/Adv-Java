package com.studentmvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.studentmvc.daoimpl.StudentDAOImpl;
import com.studentmvc.model.Student;
import com.studentmvc.serviceimpl.StudentServiceImpl;

/**
 * Servlet implementation class StudentUpdateController
 */
public class StudentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentServiceImpl studentServiceImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateController() {
        studentServiceImpl = new StudentServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Student student = studentServiceImpl.getById(id);
			request.setAttribute("student", student);
			RequestDispatcher rd = request.getRequestDispatcher("update-student.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter printWriter = response.getWriter();
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				float marks = Float.parseFloat(request.getParameter("marks"));
				String phone = request.getParameter("phone");
		        String city = request.getParameter("city");
		        String gender = request.getParameter("gender");
		        String name = request.getParameter("name");
		        Student student = new Student(id, name, phone, gender, marks, city);
		        int result = studentServiceImpl.update(id, student);
		        //RequestDispatcher rd = request.getRequestDispatcher("update-result.jsp");
		        if(result > 0) {
		        	request.setAttribute("msg", "Student Updated Successfully");
		        	response.sendRedirect("StudentController");
		        } else {
		        	request.setAttribute("errorMsg", "Problem in updating student information");
		        }
		        //rd.forward(request, response);
		        
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		}

}
