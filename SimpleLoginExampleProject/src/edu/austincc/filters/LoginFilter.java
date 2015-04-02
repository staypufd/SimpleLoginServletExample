package edu.austincc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/LoginFilter")
@WebFilter(urlPatterns = {"/*"}) 
public class LoginFilter implements Filter {

	private FilterConfig filterConfig = null;
	
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.filterConfig = null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String urlString = httpRequest.getRequestURL().toString().toLowerCase();
		
		
		if (urlString.endsWith("SimpleLoginExampleProject/".toLowerCase())) {
			chain.doFilter(request, response);
			return;
		}
		
		if (urlString.endsWith("/Login".toLowerCase())) {
			chain.doFilter(request, response);
			return;
		}
		
		if (!isAuth(httpRequest)) {
			httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return; //break filter chain, requested JSP/servlet will not be executed
        }
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	
	private boolean isAuth(HttpServletRequest request) {
		HttpSession theSession = request.getSession();
		Object theValue = theSession.getAttribute("isLoggedIn");
		boolean isLoggedIn;
		if (theValue != null) {
			isLoggedIn = (boolean)theValue;
		} else {
			isLoggedIn = false;
		}
		
		return isLoggedIn;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
