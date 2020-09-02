/**
 * 
 */
package com.openthinks.demo.data.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.openthinks.demo.data.queue.LinkedQueue;
import com.openthinks.demo.data.queue.Queue;
import com.openthinks.demo.data.stack.LinkedStack;
import com.openthinks.demo.data.stack.Stack;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryNode<T> root;

	BinaryNode<T> getRoot() {
		return root;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.TreeInterface#getRootData()
	 */
	@Override
	public T getRootData() {
		return root == null ? root.getData() : null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.TreeInterface#getHeight()
	 */
	@Override
	public int getHeight() {
		return root == null ? 0 : root.getHeight();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.TreeInterface#getNumberOfNodes()
	 */
	@Override
	public int getNumberOfNodes() {
		return root == null ? 0 : root.getNumberOfNodes();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.TreeInterface#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.TreeInterface#clear()
	 */
	@Override
	public void clear() {
		this.root = null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.openthinks.demo.data.tree.TreeIteratorInterface#getPreorderIterator()
	 */
	@Override
	public Iterator<T> getPreorderIterator() {
		return new PreorderIterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.openthinks.demo.data.tree.TreeIteratorInterface#getPostorderIterator()
	 */
	@Override
	public Iterator<T> getPostorderIterator() {
		return new PostorderIterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.openthinks.demo.data.tree.TreeIteratorInterface#getInorderIterator()
	 */
	@Override
	public Iterator<T> getInorderIterator() {
		return new InorderIterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.openthinks.demo.data.tree.BinaryTreeInterface#setTree(java.lang.Object)
	 */
	@Override
	public void setTree(T rootData) {
		BinaryNode<T> rootNode = new BinaryNode<>();
		rootNode.setData(rootData);
		this.root = rootNode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.openthinks.demo.data.tree.BinaryTreeInterface#setTree(java.lang.Object,
	 * com.openthinks.demo.data.tree.BinaryTreeInterface,
	 * com.openthinks.demo.data.tree.BinaryTreeInterface)
	 */
	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		setTree(rootData);
		root.setLeftChild(((BinaryTree<T>) leftTree).root);
		root.setRightChild(((BinaryTree<T>) rightTree).root);
	}

	class InorderIterator implements Iterator<T> {

		private Stack<BinaryNodeInterface<T>> stack = new LinkedStack<>();
		private BinaryNodeInterface<T> currentNode = root;

		@Override
		public boolean hasNext() {
			return currentNode != null || !stack.isEmpty();
		}

		@Override
		public T next() {
			BinaryNodeInterface<T> nextNode = null;

			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			if (!stack.isEmpty()) {
				nextNode = stack.pop();
				currentNode = nextNode.getRightChild();
			} else {
				throw new NoSuchElementException();
			}
			return nextNode.getData();
		}

	}

	class PreorderIterator implements Iterator<T> {
		private Stack<BinaryNodeInterface<T>> stack = new LinkedStack<>();
		private Queue<BinaryNodeInterface<T>> queue = new LinkedQueue<>();
		private BinaryNodeInterface<T> currentNode = root;

		@Override
		public boolean hasNext() {
			return currentNode != null || !stack.isEmpty();
		}

		@Override
		public T next() {
			BinaryNodeInterface<T> nextNode = null;
			while (currentNode != null) {
				stack.push(currentNode);
				queue.offer(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			if (!stack.isEmpty()) {
				currentNode = stack.pop().getRightChild();
			}
			if (!queue.isEmpty()) {
				nextNode = queue.poll();
			}
			return nextNode.getData();
		}

	}

	class PostorderIterator implements Iterator<T> {
		
		private Stack<BinaryNodeInterface<T>> stack = new LinkedStack<>();
		private BinaryNodeInterface<T> currentNode = root;

		@Override
		public boolean hasNext() {
			return currentNode != null || !stack.isEmpty();
		}

		@Override
		public T next() {
			BinaryNodeInterface<T> nextNode = null;
			while (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}
			if (!stack.isEmpty()) {
				nextNode = stack.pop();
				currentNode = nextNode.getRightChild();
			}
			
			return nextNode.getData();
		}

	}

}
