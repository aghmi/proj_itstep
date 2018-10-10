package by.aghmi.servlets.tasks;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class Task3Servlet
 */

public class Task3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Task3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String last_name = request.getParameter("lname");
		last_name.trim();
		
		Connection conn = null;
		try {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/retailer", "root", "");
			System.out.println("Created Connection :" + conn);
		} catch (SQLException e) {
			System.err.println("getConnection() error : " 
		+ e.getMessage());
			
		}
		
		try {
			response.setContentType("text/html");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT lastName FROM RETAILER.employees "
					+ "WHERE lastName LIKE '" + last_name +"%';");
			while (rs.next()) {
				response.getWriter().println(rs.getString(1));
				response.getWriter().println("<BR>");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
