package Serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.studentDAOImpl.StudentDAOImpl;

/**
 * Servlet implementation class Done
 */
@WebServlet("/Done")
public class Done extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDAOImpl obj;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Done() {
    	obj = new StudentDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
	
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
