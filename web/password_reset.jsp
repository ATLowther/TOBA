<%@ include file="./includes/header.html" %>
    <nav>
		<h1><a href="./index.jsp">TOBA</a></h1>
		<ul>		
			<li><a href="./login.jsp">Login</a></li>
			<li><a href="./new_customer.jsp">Sign up</a></li>		
		</ul>
    </nav>
    <hr>
    <body>
        <form action="/LoginServlet" method="post" id="password-reset">
            <input type="hidden" name="reset" value="true">
           Enter new password: <input type="text" name="password" value="${user.password}">
           <br />
           <input type="submit">
        </form>
<%@ include file="./includes/footer.jsp" %>
