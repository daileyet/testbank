/**
 * 
 */
package com.openthinks.ordersys.service;

import java.util.List;

import com.openthinks.ordersys.mode.Product;

/**
 * @author DAD2SZH
 *
 */
public interface ProductService {
	
	public List<Product> listAllProduct();

	public Product findProduct(String productIdstr);
}
