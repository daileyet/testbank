/**
 * 
 */
package com.openthinks.ordersys.service.impl;

import java.util.List;

import com.openthinks.ordersys.mode.Product;
import com.openthinks.ordersys.service.MockService;
import com.openthinks.ordersys.service.ProductService;

/**
 * @author DAD2SZH
 *
 */
public class ProductServiceImpl implements ProductService {
	
	@Override
	public List<Product> listAllProduct() {
		return MockService.listAllProduct();
	}

	@Override
	public Product findProduct(String productIdstr) {
		return MockService.findProduct(productIdstr);
	}
}
