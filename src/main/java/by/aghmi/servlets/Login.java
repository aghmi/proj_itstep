package by.aghmi.servlets;

import by.aghmi.control.UserMapper;
import by.aghmi.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }
    //resp.sendRedirect(req.getContextPath() + "/redirected");
    //HTTP GET REQUEST HANDLING 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("REQUEST INFO :");
		writer.println("REQUEST Context Path:"
					+ request.getContextPath());
		writer.println("REQUEST Servlet Path:" +
					request.getServletPath());
		
		writer.println("REQUEST Servlet URI:" +request.getRequestURI());
		writer.println("REQUEST Servlet URL:" +request.getRequestURL());
		writer.println("REQUEST Content Type:" + request.getContentType());
		
		writer.println("RESPONSE INFO :");
		
		writer.println("RESPONSE Servlet Content Type:" +response.getContentType());
		writer.println("RESPONSE Servlet Header Names:" +response.getHeaderNames());
		writer.println("RESPONSE Servlet Locale:" +response.getLocale());
		writer.println("RESPONSE Servlet Character Encoding:" +response.getCharacterEncoding());
		writer.println("RESPONSE Servlet Status:" +response.getStatus());
		
	}
	//HTTP POST REQUEST HANDLING
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("name");
		String userPass = request.getParameter("pass");
		
		//IS VALIDE
		UserMapper mapper = new UserMapper();
		User user = (User)mapper.findUser(userName, userPass);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("name", userName);
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request, response);
			return;
		} else {
			writer.print("LOGIN OR PASSWORD INCORRECT!-");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
			return;
		}
		
		
	}
	
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Login Servlet Initialization");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("Login Servlet Destroying");
	}

}
