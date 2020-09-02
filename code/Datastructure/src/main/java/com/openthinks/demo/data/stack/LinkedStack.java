/**
 * 
 */
package com.openthinks.demo.data.stack;

import com.openthinks.demo.data.list.LinkedList;
import com.openthinks.demo.data.list.List;

/**
 * @author dailey
 *
 */
public class LinkedStack<T> implements Stack<T> {

	private List<T> list = new LinkedList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.stack.Stack#push(java.lang.Object)
	 */
	@Override
	public void push(T t) {
		list.append(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.stack.Stack#pop()
	 */
	@Override
	public T pop() {
		int size = list.size();
		if (size == 0)
			return null;
		return list.remove(size-1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.stack.Stack#peek()
	 */
	@Override
	public T peek() {
		int size = list.size();
		if (size == 0)
			return null;
		return list.get(size-1);
	}
	
	@Override
	public boolean isEmpty() {
		return list.size()==0;
	}

}
