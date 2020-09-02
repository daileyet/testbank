/**
 * 
 */
package com.openthinks.demo.data.queue;

import com.openthinks.demo.data.list.LinkedList;
import com.openthinks.demo.data.list.List;

/**
 * @author dailey
 *
 */
public class LinkedQueue<T> implements Queue<T> {

	private List<T> list = new LinkedList<>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.queue.Queue#offer(java.lang.Object)
	 */
	@Override
	public void offer(T t) {
		list.append(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.queue.Queue#poll()
	 */
	@Override
	public T poll() {
		int size = list.size();
		if (size == 0)
			return null;
		return list.remove(0);
	}

	@Override
	public boolean isEmpty() {
		return list.size()==0;
	}
}
