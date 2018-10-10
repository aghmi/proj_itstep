package by.aghmi.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Result
 */
@WebServlet("/Result")
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Result() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter writer = response.getWriter();
		
		response.setContentType("text/html");
		writer.println("NAME FROM REQUEST: " 
					+ request.getParameter("name") + "<BR>");
		writer.println("NAME FROM SESSION: " 
				+ request.getSession().getAttribute("name") + "<BR>");
		
		writer.println("EXTRA FROM REQUEST: " 
				+ request.getParameter("EXTRA") + "<BR>");
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(5);
		writer.println("SESSION INFO: <BR>");
		writer.println("SESSION Creation Time: " + session.getCreationTime() + "<BR>");
		writer.println("SESSION Max Inactive Interval: "
					+ session.getMaxInactiveInterval() + "<BR>");
		writer.println("SESSION Id: " + session.getId() + "<BR>");
		writer.println("SESSION LastAccessedTime: " + session.getLastAccessedTime() + "<BR>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
