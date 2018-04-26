package toba.register;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import toba.business.User;
import toba.data.UserDB;

@WebServlet("/NewCustomerServlet")
public class NewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * On a new user registration, check to see if all parameters are filled in. 
	 * If not, refresh the registration page with the defined message in the /new_customer.jsp page prepended to the form.
	 * If the parameters are filled in, for now, just forward to the /success.html page.
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		if(!allParamsFilled(request)) {
			request.setAttribute("message", "Please fill out every field in the form");
			String toPage = "/new_customer.jsp";	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(toPage);
			dispatcher.forward(request, response);
		} else {			
			String firstName = request.getParameter("first-name");
			String lastName = request.getParameter("last-name");
			String phoneNumber = request.getParameter("phone-number");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			String email = request.getParameter("email");
                        
                        User user = new User(firstName, lastName, phoneNumber, address, city, state, zip, email);
                        
                        HttpSession session = request.getSession(true);
                        session.setAttribute("user", user);                                 
                        
                        UserDB.insertUser(user);
                        String toPage = "/success.jsp";	
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(toPage);
			dispatcher.forward(request, response);
		}
	}
	
	/*
	 * @param request is the incoming request object from the /new_customer.jsp form POST. 
	 * 
	 * Get a Map of all of the parameters sent in the POST request. 
	 * Loop through every entry and check the values for any empty strings.
	 * If there are any empty strings, @return false.
	 * If all parameters have a value, @return true. 
	 * 
	 */
	
	private boolean allParamsFilled(HttpServletRequest request) {
		Map<String, String[]> allParams = request.getParameterMap();
		Iterator iterator = allParams.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, String[]> param = (Map.Entry) iterator.next();	
			String[] value = param.getValue();			
			if(value[0] == "") {
				return false;
			}
		}		
		return true;
	}

}
