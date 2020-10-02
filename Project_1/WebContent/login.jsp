<%@ include file = "header.jsp" %>

<% 
String errormsg="" ;
if(session.getAttribute("autherror")!= null){
	 errormsg = (String) session.getAttribute("autherror"); 
	 session.removeAttribute("autherror");
}


%>
<body>

<div class="container-fluid">

<div class="row"> 

<div class="col-12 bg-dark text-light d-flex justify-content-center align-items-center" style="height:100vh">

       <form action="login-servlet" method="post">
       			<div class="form-group">
			    <label >User-name</label>
			    <input type="text" name="username" class="form-control"  >
			    
			    </div>
				  
			
			  <div class="form-group">
			    <label >Password</label>
			    <input type="password"  name="password" class="form-control" >
			  </div>
			  
			  
			  <button type="submit" class="btn btn-primary">Log In</button>
			  <a class="btn btn-primary" href ="register.jsp" role="button">Register</a>
			  <br>
			  <br>
			   <% if(errormsg !=""){ %>
			  
			  		
				  <div class="alert alert-danger " role="alert">
			      <%= errormsg %>
			      </div>
			  <% } %>
       </form>
 
</div>

</div>

</div>

</body>
</html>