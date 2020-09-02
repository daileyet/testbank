/**
 * 
 */
package com.openthinks.demo.data.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class BinaryTreeTest {

	BinaryTree<Integer> tree;

	/**
	 * <pre>
	 * 			      0
	 * 			-------------
	 * 			1	  		2
	 * 		---------------------
	 * 		 3     4	5       6
	 *    -------------------------		
	 *     7  8  9
	 * </pre>
	 */
	@Before
	public void setUp() {
		tree = new BinaryTree<>();
		tree.setTree(0);
		BinaryNode<Integer> rootNode = tree.getRoot();

		BinaryNode<Integer> leftChild = new BinaryNode<>(1);
		leftChild.setLeftChild(new BinaryNode<Integer>(3));
		leftChild.getLeftChild().setLeftChild(new BinaryNode<Integer>(7));
		leftChild.getLeftChild().setRightChild(new BinaryNode<Integer>(8));
		leftChild.setRightChild(new BinaryNode<Integer>(4));
		leftChild.getRightChild().setLeftChild(new BinaryNode<Integer>(9));
		rootNode.setLeftChild(leftChild);

		BinaryNode<Integer> rightChild = new BinaryNode<>(2);
		rightChild.setLeftChild(new BinaryNode<Integer>(5));
		rightChild.setRightChild(new BinaryNode<Integer>(6));
		rootNode.setRightChild(rightChild);
	}

	@Test
	public void testBasic() {
		Assert.assertNotNull(tree);
		Assert.assertEquals(4, tree.getHeight());
		Assert.assertEquals(10, tree.getNumberOfNodes());
		Assert.assertTrue(!tree.isEmpty());
		tree.clear();
		Assert.assertTrue(tree.isEmpty());
	}

	@Test
	public void testInorderIterator() {
		Iterator<Integer> iterator = tree.getInorderIterator();
		Integer[] expecteds = { 7, 3, 8, 1, 9, 4, 0, 5, 2, 6 };
		List<Integer> result = new ArrayList<>();
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		System.out.println(result);
		Integer[] actuals = result.toArray(new Integer[0]);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testPreorderIterator() {
		Iterator<Integer> iterator = tree.getPreorderIterator();
		Integer[] expecteds = { 0, 1, 3, 7, 8, 4, 9, 2, 5, 6 };
		List<Integer> result = new ArrayList<>();
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		System.out.println(result);
		Integer[] actuals = result.toArray(new Integer[0]);
		Assert.assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testPostorderIterator() {
		Iterator<Integer> iterator = tree.getPostorderIterator();
		Integer[] expecteds = { 7, 8, 3, 9, 4, 1, 5, 6, 2, 0 };
		List<Integer> result = new ArrayList<>();
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		System.out.println(result);
		Integer[] actuals = result.toArray(new Integer[0]);
		Assert.assertArrayEquals(expecteds, actuals);
	}
}
