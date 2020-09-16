/**
 * 
 */
package com.openthinks.ordersys.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openthinks.ordersys.service.OrderService;
import com.openthinks.ordersys.service.ProductService;
import com.openthinks.ordersys.service.UserService;
import com.openthinks.ordersys.service.UserServiceImpl;
import com.openthinks.ordersys.service.impl.OrderServiceImpl;
import com.openthinks.ordersys.service.impl.ProductServiceImpl;
import com.openthinks.ordersys.servlet.Action;

/**
 * @author DAD2SZH
 *
 */
public abstract class AbstractAction implements Action {
	protected UserService userService;
	protected OrderService orderService;
	protected ProductService productService;
	public AbstractAction() {
		userService = new UserServiceImpl();
		orderService = new OrderServiceImpl();
		productService = new ProductServiceImpl();
	}
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	public abstract String key();

}
