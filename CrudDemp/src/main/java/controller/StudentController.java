package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.cruddemo.daoimpl.StudentDAOImpl;
import com.cruddemo.model.Student;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAOImpl studentDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
       studentDAOImpl = new StudentDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Student> students = studentDAOImpl.getAll();
			RequestDispatcher rd = request.getRequestDispatcher("student-list.jsp");
			request.setAttribute("studentsList", students);
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
			int result = studentDAOImpl.save(student);
			
			if(result>0) {
				request.setAttribute("msg", "Student Register Successfully");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
			else {
				request.setAttribute("error", "Problem in Registration");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
	
