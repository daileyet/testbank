/**
 * 
 */
package com.openthinks.ordersys.servlet.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class RemoveFromCartAction extends AbstractAction {

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productIdstr = request.getParameter("pid");
		Cart cart = WebUtils.getSessionCart(request);
		List<CartProduct> removeList = new ArrayList<>();
		for(CartProduct cp:cart.getProds()) {
			if(cp.getProd().getID().toString().equals(productIdstr)) {
				cp.deincrease();
				if(cp.getCount()<=0) {
					removeList.add(cp);
				}
				break;
			}
		}
		for(CartProduct cp:removeList) {
			cart.getProds().remove(cp);
		}
	}

	@Override
	public String key() {
		return "remove";
	}

}
