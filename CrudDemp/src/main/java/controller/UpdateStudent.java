package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.cruddemo.daoimpl.StudentDAOImpl;
import com.cruddemo.model.Student;

/**
 * Servlet implementation class UpdateStudent
 */
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    StudentDAOImpl studentDAOImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudent() {
        studentDAOImpl = new StudentDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Student student = studentDAOImpl.getById(id);
			request.setAttribute("student", student);
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
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
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		float marks = Float.parseFloat(request.getParameter("marks"));
		Student student = new Student(id,name,phone,marks);
		int result = studentDAOImpl.update(student,id);
		//RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		if(result > 0) {
			request.setAttribute("msg", "Student Updated Successfully");
			response.sendRedirect("StudentController");
		}
		else {
			request.setAttribute("error", "Problem in Updating student information");
		}
		//rd.forward(request, response);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}
