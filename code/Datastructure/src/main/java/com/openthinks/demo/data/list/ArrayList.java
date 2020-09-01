/**
 * 
 */
package com.openthinks.demo.data.list;

import java.util.Arrays;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class ArrayList<T> implements List<T> {

	private volatile Object[] array ;
	private int lastIndex = -1;
	private final int initCapacity;
	
	public ArrayList() {
		this(18);
	}
	
	public ArrayList(int capacity) {
		this.initCapacity = capacity;
		this.array = new Object[capacity];
	}

	@Override
	public void append(T t) {
		array[++lastIndex] = t;
		ensureCapacity();
	}

	@Override
	public void insert(int index, T t) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		for (int i = lastIndex+1; i > index; i--) {
			array[i] = array[i-1];
		}
		array[index] = t;
		++lastIndex;
		ensureCapacity();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int index) {
		if (index < 0 || (index + 1) > size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		Object deleted = array[index];
		for (int i = index; i < lastIndex; i++) {
			array[i] = array[i + 1];
		}
		array[lastIndex] = null;
		--lastIndex;
		ensureCapacity();
		return (T) deleted;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index < 0 || (index + 1) > size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return (T) array[index];
	}

	@Override
	public int size() {
		return (lastIndex + 1);
	}

	void ensureCapacity() {
		// simple strategy: size greater than half capacity will extend
		int bigPoint = capacity() / 2, smallPoint = capacity() / 4;
		if (bigPoint > lastIndex && smallPoint < lastIndex) {
			return;
		}
		int newCap = capacity();
		if (bigPoint <= lastIndex) { // extend
			newCap = capacity() * 2 ;
		}
		if (smallPoint >= lastIndex && smallPoint > initCapacity) {// cut down
			newCap = bigPoint;
		}
		synchronized (this) {
			array = Arrays.copyOf(array, newCap);
		}
	}

	synchronized int capacity() {
		return array.length;
	}

}
