/**
 * 
 */
package com.openthinks.demo.data.queue;

/**
 * @author dailey
 *
 */
public interface Queue<T> {
	
	public void offer(T t);

	public T poll();
}
