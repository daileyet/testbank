/**
 * 
 */
package com.openthinks.ordersys.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openthinks.ordersys.utils.WebUtils;

/**
 * @author DAD2SZH
 *
 */
public class SubmitOrderAction extends AbstractAction {

	@Override
	public String key() {
		return "submit-order";
	}
	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.process(request, response);
		
		boolean success = orderService.createOrder(WebUtils.getSessionCart(request));
		
		response.sendRedirect(request.getContextPath()+"/main/order/index");
		
	}

}
