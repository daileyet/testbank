/**
 * 
 */
package com.openthinks.demo.data.list;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class LinkedList<T> implements List<T> {

	final class Node {
		T obj = null;
		Node next = null;

		Node() {
		}

		Node(T obj, Node next) {
			this.obj = obj;
			this.next = next;
		}
	}

	private Node head;
	private volatile int size = 0;

	public LinkedList() {
		head = new Node();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.list.List#append(java.lang.Object)
	 */
	@Override
	public void append(T t) {
		Node preNode = findPrevNode(size());
		Node newNode = new Node(t, null);
		preNode.next=newNode;
		synchronized (this) {
			size++;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.list.List#insert(int, java.lang.Object)
	 */
	@Override
	public void insert(int index, T t) {
		Node preNode = findPrevNode(index);
		Node newNode = new Node(t, preNode.next);
		preNode.next = newNode;
		synchronized (this) {
			size++;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.list.List#remove(int)
	 */
	@Override
	public T remove(int index) {
		Node preNode = findPrevNode(index);
		Node removed = preNode.next;
		preNode.next = removed.next;
		removed.next = null;
		synchronized (this) {
			size--;
		}
		return removed.obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.list.List#get(int)
	 */
	@Override
	public T get(int index) {
		if(size==0) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		Node preNode = findPrevNode(index);
		return preNode.next.obj;
	}

	Node findPrevNode(int index) {
		if (index < 0 || (index ) > size())
			throw new ArrayIndexOutOfBoundsException(index);
		Node node = head;
		if(index==0)
			return node;
		int i=index;
		while(i>0) {
			node=node.next;
			i--;
		}
		return node;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.list.List#size()
	 */
	@Override
	public synchronized int size() {
		return size;
	}

}
