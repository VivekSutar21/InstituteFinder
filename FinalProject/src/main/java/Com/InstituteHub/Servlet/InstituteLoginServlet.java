package Com.InstituteHub.Servlet;

import java.io.IOException;

import Com.InstituteHub.Dao.*;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class InstituteLoginServlet
 */ 
//@WebServlet("/InstituteLoginServlet")
public class InstituteLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static Institute_UserDao institute_userDao = new Institute_UserDaoImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InstituteLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(institute_userDao.isValidUser(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			response.sendRedirect("InstituteInterface.html");

		}else {
			response.sendRedirect("InstituteHome.html");
			System.out.println("Error: Wrong Student Login Details...");
		}
	}

}
