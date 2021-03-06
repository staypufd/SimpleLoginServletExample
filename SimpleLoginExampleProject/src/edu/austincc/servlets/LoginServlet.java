package edu.austincc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Default URL to go to
		String url = "/index.jsp";
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		
		if ( action.equalsIgnoreCase("login") ) {
			if ( (name.equalsIgnoreCase("Sam") && (password.equalsIgnoreCase("abc")))) {
				HttpSession theSession = request.getSession();
				theSession.setAttribute("isLoggedIn", true);
				url = "/main.jsp";
				request.setAttribute("name", name);
			} else {
				url = "/login.jsp";
			}
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
