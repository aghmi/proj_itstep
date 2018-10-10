package by.aghmi.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Welcome
 */

public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter  out = response.getWriter();
		String userName = request.getParameter("name");
		response.setContentType("text/html");
		
		out.print("WELCOME , " + userName );
		out.print("<BR>");
		out.print("<FORM ACTION='Result' METHOD='GET'>");
		out.print("<INPUT TYPE='TEXT' NAME='EXTRA'>");
		//out.print("<INPUT TYPE='TEXT' NAME='name' VALUE = "+userName+">");
		out.print("<BR>");
		out.print("<INPUT TYPE='SUBMIT' VALUE='GO!'>");
		out.print("</FORM>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("request was here");
		doGet(request, response);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("Welcome Servlet Initialization");
	}
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Welcome Servlet Destroying ");
	}
	
	
}
