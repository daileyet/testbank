package com.openthinks.ordersys.servlet;

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

import com.openthinks.ordersys.mode.SysUser;
import com.openthinks.ordersys.utils.WebUtils;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(urlPatterns = {"/main/*"})
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest httpReq = (HttpServletRequest) request;
		SysUser user = WebUtils.getSessionUser(httpReq);
		if(user==null) {
			((HttpServletResponse)response).sendRedirect(httpReq.getContextPath()+"/login.jsp");
			return;
		}
		httpReq.setAttribute("userName", user.getUserName());
		httpReq.setAttribute("userId", user.getID());
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
