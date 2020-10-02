package com.project1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String username="";
	String password="";
	 String error="";
	 HttpSession session;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		try{
			 username = request.getParameter("username");
			 password = request.getParameter("password");
			 if(username == "" || password == ""){
				 error ="Both Fields Are Mendatory!";
				 displayError(session,response,error);
			 }
			 boolean auth = AuthService.validateUser(username, password);
			 if(auth == true){
				 session.setAttribute("AUTH", true);
				 session.setAttribute("username", username);
				 //request.getRequestDispatcher("/post-servlet").forward(request, response);
				 request.getRequestDispatcher("/HomeServlet").forward(request, response);
			 //response.sendRedirect("home.jsp");
			 }
			 else
			 {
				 
				 error="Invalid Username Or Password!";
				 displayError(session, response,error);
				 
			 }
			
		}catch (Exception e) {
			
			
		}
	}
	private void displayError(HttpSession session,HttpServletResponse response,String error)throws ServletException, IOException {
		session.setAttribute("autherror", error);
		response.sendRedirect("login.jsp");
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
