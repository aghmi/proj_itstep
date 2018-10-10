package by.aghmi.servlets.tasks;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Task2Servlet
 */
public class Task2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Task2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("error");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String a_str = request.getParameter("a");
		String b_str = request.getParameter("b");

		int a = Integer.parseInt(a_str);
		int b = Integer.parseInt(b_str);
		
		if(b==0){
			response.setContentType("text/html");
			response.getWriter().println("DIV BY ZERO");
			RequestDispatcher rd = request.getRequestDispatcher("/math.html");
			rd.include(request, response);
			return;
		} //else {
			
		response.getWriter().println(a / b);
		//}
		
		
	}

}
