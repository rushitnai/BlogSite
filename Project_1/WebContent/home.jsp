<%@page import="com.project1.PostData"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ include file="header.jsp" %>
    
    <% 
    if(session.getAttribute("AUTH")== null){
    	
   		response.sendRedirect("login.jsp");
    }
    
    %>
    <%
     ArrayList<PostData> post_list = new ArrayList<>();
    if(session.getAttribute("posts") != null){
    	post_list= (ArrayList<PostData>) session.getAttribute("posts");
    }
    %>

<body>

<div class="container-fluid">
		<div class="row">
		
		<div class="col-6 bg-dark text-light  d-flex align-item-center "  style="height:5vh">
		
			HOME PAGE
		</div>
		<div class="col-6 bg-dark text-light justify-content-end d-flex align-item-center "  style="height:5vh">
		
			<a class=" btn btn-secondary" href="logout-servlet" role="button" >LOG OUT</a>
		</div>
		</div>
</div>

		<div class="row">
			<div class="col-3"> </div>
			<div class="col-6 bg-secondary d-flex align-iteam-center " style="height: 70px">
			<form action="post-servlet" class="col-12 ">
			<div class="form-row ">
			
			<div class="col-10">
				<input class="form-control form-control-lg" type="text" name="posttext"placeholder="Post Here..">
		
			</div>
			<div class="col-2" > 
			<button type="submit" class="btn btn-dark ml-1">POST</button>
			
			</div>
			 </div>
		
			</form>
			
			</div>
		
		</div>
		
		
		<div class="col">
		
		<% for( PostData post : post_list){ %>
			

		
		<br>
		<div class="row mt-1">
		<div class="col-3"></div>
		<div class="col-6 "> 
		
		<div class= "card">
		
		<div class="card-header">
		    <%= post.getUsername() %>
		</div>
		<div class="card-body">
		<p class="card-text">
			<%= post.getPosttext() %>
			</p>
		</div>
		
		
		</div>
		</div>
		</div>
		<% } %>
		</div>

</body>
</html>