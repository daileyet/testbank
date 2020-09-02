/**
 * 
 */
package com.openthinks.demo.data.tree;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public interface BinaryNodeInterface<T> {

	public T getData();

	public void setData(T data);

	public BinaryNodeInterface<T> getLeftChild();

	public BinaryNodeInterface<T> getRightChild();

	public void setLeftChild(BinaryNodeInterface<T> leftChild);

	public void setRightChild(BinaryNodeInterface<T> rightChild);

	public boolean hasLeftChild();

	public boolean hasRightChild();

	public boolean isLeaf();

	/**
	 * 计算以该结点为根的子树的结点数目
	 * 
	 * @return
	 */
	public int getNumberOfNodes();

	/**
	 * 计算以该结点为根的子树的高度
	 * 
	 * @return
	 */
	public int getHeight();

}
