/**
 * 
 */
package com.openthinks.ordersys.service.impl;

import java.util.List;

import com.openthinks.ordersys.mode.Cart;
import com.openthinks.ordersys.mode.Order;
import com.openthinks.ordersys.mode.OrderProduct;
import com.openthinks.ordersys.service.OrderService;

/**
 * @author DAD2SZH
 *
 */
public class OrderServiceImpl implements OrderService {

	@Override
	public List<OrderProduct> listOrderProduct(Long orderId) {
		return null;
	}

	@Override
	public List<Order> listOrders(Long id) {
		return null;
	}

	@Override
	public boolean createOrder(Cart sessionCart) {
		return false;
	}

}
