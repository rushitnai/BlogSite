package com.project1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/post-servlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String post_text;
	String username="default";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			Class.forName(JdbcRegister.driver);
			Connection con = DriverManager.getConnection(JdbcRegister.url,JdbcRegister.username,JdbcRegister.password);
			HttpSession session= request.getSession();
			post_text= request.getParameter("posttext");
			username= (String) session.getAttribute("username");
			PostData pd = new PostData();
			pd.setLikecount(0);
			pd.setDlikecount(0); 
			pd.setUsername(username);
			pd.setPosttext(post_text);
			
			
			String sql = "INSERT INTO postdata (posttext,likecount,dlikecount,username) VALUES (?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,pd.getPosttext());
			ps.setInt(2, pd.getLikecount());
			ps.setInt(3,pd.getDlikecount() );
			ps.setString(4, pd.getUsername());
			ps.executeUpdate();
			
			request.getRequestDispatcher("/HomeServlet").forward(request, response);
			//response.sendRedirect("home.jsp");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
