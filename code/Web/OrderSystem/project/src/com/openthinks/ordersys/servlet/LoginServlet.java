/**
 * 
 */
package com.openthinks.ordersys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openthinks.ordersys.mode.SysUser;
import com.openthinks.ordersys.service.UserService;
import com.openthinks.ordersys.service.UserServiceImpl;
import com.openthinks.ordersys.utils.WebUtils;

/**
 * @author DAD2SZH
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 3991461348160584895L;

	UserService userService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userService = new UserServiceImpl();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String userName = request.getParameter("user_name");
		String userPass = request.getParameter("user_pass");
		if(userName==null || userName.trim().length()==0 || userPass==null || userPass.trim().length()==0) {
			response.getWriter().append("\nLogin error:").append("Invalid user name or password");
			return;
		}
		SysUser user=userService.findUser(userName, userPass);
		if(user==null) {
			response.getWriter().append("\nLogin error:").append("Not correct");
			return;
		}
		request.getSession(true).setAttribute(WebUtils.SESSION_ATTR_USER, user);
		response.sendRedirect(request.getContextPath()+"/main/index");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	
	
}
