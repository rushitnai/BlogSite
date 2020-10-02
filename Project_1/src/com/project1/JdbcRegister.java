package com.project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcRegister {
	
	public static String driver ="com.mysql.cj.jdbc.Driver";
	public static String url ="jdbc:mysql://localhost:3306/test";
	public static String username ="root";
	public static String password ="";
	
	public static void  registerUser(Users user) throws Exception{
		
		try{
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			
			String sql = "INSERT INTO USERS (USERNAME,PASSWORD,EMAIL,MOBILE) VALUES (?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMobile());
			
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			throw e;
		
		}
	}

}
