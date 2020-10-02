package com.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import com.mysql.cj.xdevapi.Statement;

public class AuthService {
	
	public static boolean auth=false;
	 
	
	
	
	public static boolean validateUser (String username, String pass){
		
		try{
			
			Class.forName(JdbcRegister.driver);
			Connection con = DriverManager.getConnection(JdbcRegister.url,JdbcRegister.username,JdbcRegister.password);
			
			//sql = "SELECT `USERNAME` FROM `users` WHERE USERNAME = " +username +"AND PASSWORD ="+ pass +";";
			String sql = "select * from users where username=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();  
			auth=rs.next();  
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return auth;
	}

}
