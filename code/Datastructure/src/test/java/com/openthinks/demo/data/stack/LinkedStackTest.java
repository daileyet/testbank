/**
 * 
 */
package com.openthinks.demo.data.stack;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class LinkedStackTest {

	@Test
	public void testAll() {
		Stack<Integer> stack = new LinkedStack<>();
		Assert.assertEquals(true, stack.isEmpty());
		
		stack.push(1);
		Assert.assertEquals(false, stack.isEmpty());
		stack.push(2);
		Assert.assertEquals(Integer.valueOf(2), stack.peek());
		
		Integer actual = stack.pop();
		Assert.assertEquals(Integer.valueOf(2), actual);
		
		actual = stack.pop();
		Assert.assertEquals(Integer.valueOf(1), actual);
		Assert.assertEquals(true, stack.isEmpty());
		
		Assert.assertNull(stack.pop());
	}
}
