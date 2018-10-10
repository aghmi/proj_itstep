package by.aghmi.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ParamServlet2
 */
@WebServlet(
			urlPatterns = {"/example" , "/param2", "/p2"},
			initParams = {
					@WebInitParam(name = "phone1", value = "+37525154564"),
					@WebInitParam(name = "phone2" , value = "+37525154564")
			}, 
			loadOnStartup = 0
			
		)
public class ParamServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String phone1;
    private String phone2;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		this.phone1 = config.getInitParameter("phone1");
		this.phone2 = config.getInitParameter("phone2");
		System.out.println(this.getServletContext().getContextPath() + " - PARAMS VALS:" 
					+ phone1 + " " + phone2);;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("ParamServlet2 : Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
