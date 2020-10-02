package com.project1;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;


@WebServlet("/register-servlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String error="";
       
	String username,email,password,mobile;
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session =request.getSession();
		try{
			
			 username =request.getParameter("username");
			 email = request.getParameter("email");
			 mobile = request.getParameter("mobile");
			 password = request.getParameter("password");
			 if(username == "" || email== "" || mobile == "" ||password == ""){
				 error ="All Fields Are Mendatory";
				 displayError(session,response);
			 }
			 else{
				 Users user = new Users();
				 user.setEmail(email);
				 user.setMobile(mobile);
				 user.setPassword(password);
				 user.setUsername(username);
				 JdbcRegister.registerUser(user);
				 
				 response.sendRedirect("login.jsp");
				 
				 
				 
			 }
			 
			 
		}catch(Exception e){
			error="User Already Exist!!";
			displayError(session,response);
			
		}
	
	}
	private void displayError(HttpSession session,HttpServletResponse response)throws ServletException, IOException {
		session.setAttribute("error", error);
		response.sendRedirect("register.jsp");
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
