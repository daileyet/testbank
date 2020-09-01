/**
 * 
 */
package com.openthinks.demo.data.stack;

/**
 * @author dailey
 *
 */
public interface Stack<T> {

	public void push(T t);

	public T pop();

	public T peek();
}
