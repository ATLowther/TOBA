<%@page contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./includes/header.html" %>
        
        <nav>
		<h1><a href="./index.jsp">TOBA</a></h1>
		<ul>		
			<li><a href="./login.jsp">Login</a></li>
			<li><a href="./new_customer.jsp">Sign up</a></li>		
		</ul>
	</nav>
	<hr>	
	
	<div class="login-form">
		<form action="/LoginServlet" method="post" id="user-login">
			<label for="username">Username:</label> 
			<input type="text" name="username" required>
			<br />
			<label for="password">Password:</label>
			<input type="password" name="password" required>
			<br />
			<input type="submit" value="Login">
		</form> 
		<br /><br />
		<div class="new-user">
			<a href="new_customer.jsp">New user? Sign up here.</a>
                        <br />
                        <a href="password_reset.jsp">Reset Password</a>
		</div>		
	</div>
        
<%@ include file="./includes/footer.jsp" %>