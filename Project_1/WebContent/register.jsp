<%@ include file ="header.jsp"  %>

<% 
String errormsg="" ;
if(session.getAttribute("error")!= null){
	 errormsg = (String) session.getAttribute("error"); 
	 session.removeAttribute("error");
}


%>
<body>

<div class="container-fluid">

<div class="row"> 

<div class="col-12 bg-dark text-light d-flex justify-content-center align-items-center" style="height:100vh">

       <form action="register-servlet" method="post">
       			<div class="form-group">
			    <label >User-name</label>
			    <input type="text" name="username" class="form-control"  >
			    
			    </div>
				    <div class="form-group">
				    <label >Email address</label>
				    <input type="email" name="email" class="form-control"  >
				    
				  </div>
			
			  <div class="form-group">
			    <label >Password</label>
			    <input type="password"  name="password" class="form-control" >
			  </div>
			  <div class="form-group">
			    <label>MOBILE No</label>
			    <input type="text" name="mobile" class="form-control" >
			    
			    </div>
			  
			  <button type="submit" class="btn btn-primary ">Register  </button>
			  <a class="col-6 btn btn-primary  justify-content-end" href ="login.jsp"   role="button">Log In</a>
			  <br>
			  <br>
			  <% if(errormsg !=""){ %>
			  
			  		
				  <div class="col-12 alert alert-danger " role="alert">
			      <%= errormsg %>
			      </div>
			  <% } %>
			  
       </form>
 
</div>

</div>

</div>

</body>
</html>