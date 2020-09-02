/**
 * 
 */
package com.openthinks.demo.data.tree;

import java.util.Iterator;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public interface TreeIteratorInterface<T> {

	/**
	 * 前序遍历
	 * @return
	 */
	public Iterator<T> getPreorderIterator();

	/**
	 * 后序遍历
	 * @return
	 */
	public Iterator<T> getPostorderIterator();

	/**
	 * 中序遍历
	 * @return
	 */
	public Iterator<T> getInorderIterator();
}
