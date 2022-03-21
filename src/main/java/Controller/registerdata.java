package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Testdata.UserDao;
import Userinfo.Userdata;

/**
 * Servlet implementation class registerdata
 */
@WebServlet("/registerdata")
public class registerdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public registerdata() {
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
	
		doGet(request, response);
		
		
		UserDao daoimpl=new UserDao();
		System.out.println("reached");
		Userdata userdata=new Userdata();
		userdata.setName(request.getParameter("name"));
		userdata.setMobile(request.getParameter("mobile"));
		userdata.setPassword(request.getParameter("password"));
		userdata.setarea(request.getParameter("area"));
		userdata.setCity(request.getParameter("city"));
		userdata.setState(request.getParameter("state"));
		
		userdata.setCountry(request.getParameter("country"));
		
		daoimpl.addUserdata(userdata);
		System.out.println("registration successfully done");
		
	}

}
