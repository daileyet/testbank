/**
 * 
 */
package com.openthinks.ordersys.servlet.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openthinks.ordersys.mode.Cart;
import com.openthinks.ordersys.mode.Cart.CartProduct;
import com.openthinks.ordersys.utils.WebUtils;

/**
 * @author DAD2SZH
 *
 */
public class AddToCartAction extends AbstractAction {

	
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productIdstr = request.getParameter("pid");
		Cart cart = WebUtils.getSessionCart(request);
		boolean find=false;
		for(CartProduct cp:cart.getProds()) {
			if(cp.getProd().getID().toString().equals(productIdstr)) {
				find=true;
				cp.increase();
				break;
			}
		}
		if(find==true)
			return;
		CartProduct cp = new CartProduct(productService.findProduct(productIdstr),1);
		cart.getProds().add(cp);
	}

	
	@Override
	public String key() {
		return "add";
	}
}
