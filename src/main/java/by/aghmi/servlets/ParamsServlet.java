package by.aghmi.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class ParamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String email1 = "";
	private String email2 = "";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		email1 = config.getInitParameter("email1");
		email2 = config.getInitParameter("email2");
	}
	

    public ParamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("PARAM #1: " 
				+ this.getServletConfig().getInitParameter("email1") + "<BR>");
		out.println("PARAM #2: " 
				+ this.getServletConfig().getInitParameter("email2") + "<BR>");
		out.println("PARAMS VIA INIT() METHOD:<BR>");
		out.println("PARAM #1: " + email1 + "<BR>");
		out.println("PARAM #2: " + email2 + "<BR>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
