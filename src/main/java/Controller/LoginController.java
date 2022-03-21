package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Testdata.UserDao;
import Userinfo.Userdata;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		doGet(request, response);
		UserDao daoimpl=new UserDao();
		Userdata userdata=new Userdata();
		userdata.setName(request.getParameter("uname"));
		userdata.setPassword(request.getParameter("password"));
		
		String name=userdata.getName();
		
		HttpSession session=null;
		session=request.getSession(true);
		session.setAttribute("uname",name);
		System.out.println("Value="+session.getAttribute("uname").toString());
		boolean test=false;
				test=daoimpl.loginUser(userdata);
		if(test==true)
		{
			
			response.sendRedirect("login.jsp");
			System.out.println("Login Success");	
		}
		else
		{

			response.sendRedirect("passwordMismatch.html");
			System.out.println("Login fail");
		}
		
			
	}

}
