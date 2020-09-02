/**
 * 
 */
package com.openthinks.demo.data.tree;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class BinaryNode<T> implements BinaryNodeInterface<T> {
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;

	public BinaryNode() {
	}
	
	
	public BinaryNode(T data) {
		super();
		this.data = data;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.BinaryNodeInterface#getData()
	 */
	@Override
	public T getData() {
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.openthinks.demo.data.tree.BinaryNodeInterface#setData(java.lang.Object)
	 */
	@Override
	public void setData(T data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.BinaryNodeInterface#getLeftChild()
	 */
	@Override
	public BinaryNodeInterface<T> getLeftChild() {
		return left;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.BinaryNodeInterface#getRightChild()
	 */
	@Override
	public BinaryNodeInterface<T> getRightChild() {
		return right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.openthinks.demo.data.tree.BinaryNodeInterface#setLeftChild(com.openthinks
	 * .demo.data.tree.BinaryNodeInterface)
	 */
	@Override
	public void setLeftChild(BinaryNodeInterface<T> leftChild) {
		this.left = (BinaryNode<T>) leftChild;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.BinaryNodeInterface#setRightChild(com.
	 * openthinks.demo.data.tree.BinaryNodeInterface)
	 */
	@Override
	public void setRightChild(BinaryNodeInterface<T> rightChild) {
		this.right = (BinaryNode<T>) rightChild;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.BinaryNodeInterface#hasLeftChild()
	 */
	@Override
	public boolean hasLeftChild() {
		return left != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.BinaryNodeInterface#hasRightChild()
	 */
	@Override
	public boolean hasRightChild() {
		return right != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.BinaryNodeInterface#isLeaf()
	 */
	@Override
	public boolean isLeaf() {
		return !hasLeftChild() && !hasRightChild();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.BinaryNodeInterface#getNumberOfNodes()
	 */
	@Override
	public int getNumberOfNodes() {
		return 1 + (hasLeftChild() ? left.getNumberOfNodes() : 0) + (hasRightChild() ? right.getNumberOfNodes() : 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.BinaryNodeInterface#getHeight()
	 */
	@Override
	public int getHeight() {
		return getHeight(this);
	}
	
    private int getHeight(BinaryNode<T> node){
        int height = 0;
        if(node != null)
            height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return height;
    }

}
