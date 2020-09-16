/**
 * 
 */
package com.openthinks.ordersys.service;

import java.util.ArrayList;
import java.util.List;

import com.openthinks.ordersys.mode.Product;

/**
 * @author DAD2SZH
 *
 */
public class MockService {

	static final List<Product> products = new ArrayList<Product>();

	static {
		for (int i = 0; i < 10; i++) {
			Product prod = new Product();
			prod.setID(Long.valueOf(i));
			prod.setProdName("商品-" + i);
			prod.setProdCount(100);
			products.add(prod);
		}
	}

	public static List<Product> listAllProduct() {
		return products;
	}

	public static Product findProduct(String productIdstr) {
		return products.stream().filter((e) -> {

			return e.getID().toString().equals(productIdstr);
		}).findFirst().get();
	}

}
