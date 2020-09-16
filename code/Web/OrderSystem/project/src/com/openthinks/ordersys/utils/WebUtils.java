/**
 * 
 */
package com.openthinks.ordersys.utils;

import javax.servlet.http.HttpServletRequest;

import com.openthinks.ordersys.mode.Cart;
import com.openthinks.ordersys.mode.SysUser;

/**
 * @author DAD2SZH
 *
 */
public class WebUtils {
	
	public static final String SESSION_ATTR_USER = "X_SU_scdasdlalx20x";
	private static final String SESSION_ATTR_CART = "X_SC_ssssssssxxss";
	public static SysUser getSessionUser(HttpServletRequest req) {
		SysUser user = (SysUser)req.getSession().getAttribute(WebUtils.SESSION_ATTR_USER);
		return user;
	}
	public static Cart getSessionCart(HttpServletRequest req) {
		Cart cart = (Cart) req.getSession().getAttribute(WebUtils.SESSION_ATTR_CART);
		if(cart==null) {
			cart =  new Cart();
			cart.setUser(getSessionUser(req));
			req.getSession().setAttribute(SESSION_ATTR_CART, cart);
		}
		return cart;
	}

	
}
