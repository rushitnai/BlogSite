package com.project1;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.sql.*;

import javax.servlet.http.HttpSession;



public class ReadPost {
	
	public static ArrayList<PostData> getAllPost() throws ClassNotFoundException, SQLException {
//	    Connection conn=DBConnection.getDBConnection().getConnection();
		Class.forName(JdbcRegister.driver);
		Connection con = DriverManager.getConnection(JdbcRegister.url,JdbcRegister.username,JdbcRegister.password);
		Statement stm= con.createStatement();
		
	    
	    String sql = "Select * From postdata";
	    ResultSet rst;
	    rst = stm.executeQuery(sql);
	    ArrayList<PostData> postlist = new ArrayList<>();
	    while (rst.next()) {
	    	String posttext,un;
	    	int l,dl;
	    	posttext = rst.getString("posttext");
	    	l= rst.getInt("likecount");
	    	dl=rst.getInt("dlikecount");
	    	un= rst.getString("username");
	        PostData postobj =new PostData(l,dl,posttext,un);
	        postlist.add(postobj);
	    }
	    Collections.reverse(postlist);
	    return postlist;
	}

}
