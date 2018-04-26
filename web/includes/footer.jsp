<%@page import="java.time.LocalDate"%>
<%
    LocalDate currentDate = LocalDate.now();
    int currentYear = currentDate.getYear();
%>
<p>&copy; Copyright <%= currentYear %> Austin Lowther </p>

</body>
</html>
