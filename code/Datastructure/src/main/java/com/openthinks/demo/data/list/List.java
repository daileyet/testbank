/**
 * 
 */
package com.openthinks.demo.data.list;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public interface List<T> {
	
	public void append(T t);
	
	public void insert(int index,T t);
	
	public T remove(int index);
	
	public T get(int index);
	
	public int size();
}
