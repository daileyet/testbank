/**
 * 
 */
package com.openthinks.demo.data.queue;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class LinkedQueueTest {
	@Test
	public void testAll() {
		Queue<Integer> queue = new LinkedQueue<>();
		Assert.assertEquals(true, queue.isEmpty());
		
		queue.offer(1);
		Assert.assertEquals(false, queue.isEmpty());
		queue.offer(2);
		
		Integer actual = queue.poll();
		Assert.assertEquals(Integer.valueOf(1), actual);
		
		actual = queue.poll();
		Assert.assertEquals(Integer.valueOf(2), actual);
		Assert.assertEquals(true, queue.isEmpty());
		
		Assert.assertNull(queue.poll());
	}
}
