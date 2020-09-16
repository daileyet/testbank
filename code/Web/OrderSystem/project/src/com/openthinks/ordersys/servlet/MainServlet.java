package com.openthinks.ordersys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openthinks.ordersys.service.OrderService;
import com.openthinks.ordersys.service.ProductService;
import com.openthinks.ordersys.service.impl.OrderServiceImpl;
import com.openthinks.ordersys.service.impl.ProductServiceImpl;
import com.openthinks.ordersys.utils.WebUtils;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main/index")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductService productService;
	OrderService orderService;
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		productService = new ProductServiceImpl();
		orderService = new OrderServiceImpl();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("prods", productService.listAllProduct());
		request.setAttribute("cart",WebUtils.getSessionCart(request));
		String action = request.getParameter("act");
		Actions.get(action).process(request, response);
		
//		response.sendRedirect(request.getContextPath()+"/main/index");
		request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
