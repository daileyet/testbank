/**
 * 
 */
package com.openthinks.ordersys.servlet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.openthinks.ordersys.servlet.action.AddToCartAction;
import com.openthinks.ordersys.servlet.action.RemoveFromCartAction;

/**
 * @author DAD2SZH
 *
 */
public class Actions {
	static Map<String,Action> actionMap = new ConcurrentHashMap<>();
	static {
		register(new AddToCartAction());
		register(new RemoveFromCartAction());
	}
	
	public static Action get(String key) {
		if(key==null)
			return DEFAULT;
		return actionMap.getOrDefault(key, DEFAULT);
	}
	
	public static void register(Action action) {
		actionMap.put(action.key(), action);
	}
	
	static Action DEFAULT = (req,resp)->{};
}
