package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import toba.business.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* 
	 * When a user enters their username and password to login, their input will be validated.
	 * If the password is valid for the given username, the client will be forwarded to their account activity page.
	 * If the password is not valid for the given username, the client will be forwarded to the login failure page.
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		
		String toPage = "";		
		
                
                /*
                *  This servlet is currently being used for multiple purposes.
                *  The first part of the conditional is only running when
                *  the user is trying to reset their password through the
                *  password reset page.
                *
                *
                *  This logic should be separated and moved to its own servlet
                *
                *  The else part of the conditional runs for a regular login attempt
                */
                User user = (User) request.getSession().getAttribute("user");
                if(request.getParameter("reset") != null) {                    
                    user.setPassword(password);                    
                    request.getSession().setAttribute("user", user);                    
                    
                    toPage = "/account_activity.jsp";
                } else {           
                    System.out.println(user.getPassword());
                    System.out.println(user.getUsername());
                    if(user.getUsername().equals(username) && user.getPassword().equals(password))
                        toPage = "/account_activity.jsp";
                    else
                        toPage = "/login_failure.jsp";
                }
                
		
						
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(toPage);
		dispatcher.forward(request, response);
		
			
	}

}
