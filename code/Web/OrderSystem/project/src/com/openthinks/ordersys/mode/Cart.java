package com.openthinks.ordersys.mode;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	public static class CartProduct {
		private Product prod;
		private Integer count = 0;

		public CartProduct(Product prod, Integer count) {
			super();
			this.prod = prod;
			this.count = count;
		}

		public CartProduct(Product prod) {
			super();
			this.prod = prod;
		}
		
		public Product getProd() {
			return prod;
		}

		public void setProd(Product prod) {
			this.prod = prod;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public void increase() {
			this.count = count == null ? 1 : (count + 1);
		}

		public void deincrease() {
			this.count = count == null ? 0 : (count - 1);
		}
	}

	private SysUser user;
	private final List<CartProduct> prods = new ArrayList<>();

	
	public void reset() {
		prods.clear();
	}
	
	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public List<CartProduct> getProds() {
		return prods;
	}

}
