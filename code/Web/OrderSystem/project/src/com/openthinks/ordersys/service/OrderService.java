/**
 * 
 */
package com.openthinks.ordersys.service;

import java.util.List;

import com.openthinks.ordersys.mode.Cart;
import com.openthinks.ordersys.mode.Order;
import com.openthinks.ordersys.mode.OrderProduct;

/**
 * @author DAD2SZH
 *
 */
public interface OrderService {

	public List<OrderProduct> listOrderProduct(Long orderId);

	public List<Order> listOrders(Long id);

	public boolean createOrder(Cart sessionCart);
}
