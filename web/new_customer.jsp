<%@ include file="./includes/header.html" %>
	<nav>
		<h1><a href="./index.jsp">TOBA</a></h1>
		<ul>		
			<li><a href="./login.jsp">Login</a></li>
			<li><a href="./new_customer.jsp">Sign up</a></li>		
		</ul>
	</nav>
	<hr>	
	
	<!-- Check to see if attribute was passed from the server in an instance where 
	the client forgot to fill out one of the required parameters. -->	
	

	<div class="new-customer-form">
		
		<form action="/NewCustomerServlet" method="post" id="user-signup">
			<i>${message}</i>
			<br />
			First Name: <input type="text" name="first-name" required>
			<br />
			Last Name: <input type="text" name="last-name" required>
			<br />
			Phone Number: <input type="tel" name="phone-number" required>
			<br />
			Address: <input type="text" name="address" required>
			<br />
			City: <input type="text" name="city" required>
			<br />
			State: <input type="text" name="state" max="2" required>
			<br />
			Zipcode: <input type="text" name="zip" max="5" required>
			<br />
			<!-- Not required so server-side validation can be tested. -->
			Email: <input type="email" name="email" >
			<br />
			<input type="submit" value="Submit">			
		</form>				
	</div>
                        
<%@ include file="./includes/footer.jsp" %>