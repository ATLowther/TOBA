<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./includes/header.html" %>

	<nav>
		<h1><a href="./index.jsp">TOBA</a></h1>
		<ul>		
			<li><a href="./login.jsp">Login</a></li>
			<li><a href="./new_customer.jsp">Sign up</a></li>		
		</ul>
	</nav>
	<hr>	
        
        <c:choose>
            <c:when test="${user != null}">
                <p>Welcome, ${user.firstName} ${user.lastName}</p> 
                <br />
            </c:when>
            <c:otherwise>
                <p>Not logged in</p>
                <br />
            </c:otherwise>
        </c:choose>	

<%@ include file="./includes/footer.jsp" %>