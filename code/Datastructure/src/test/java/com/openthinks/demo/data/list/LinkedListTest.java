/**
 * 
 */
package com.openthinks.demo.data.list;

import org.junit.Test;

import junit.framework.Assert;

/**
 * @author dailey.dai@openthinks.com
 *
 */
public class LinkedListTest {

	@Test
	public void testAll() {
		List<String> testList = new LinkedList<>();
		Assert.assertEquals(0, testList.size());
		
		for(int i=0;i<10;i++) {
			testList.append(String.valueOf(i));
			Assert.assertEquals(i+1, testList.size());
			Assert.assertEquals(String.valueOf(i), testList.get(i));
		}
		Assert.assertEquals(10, testList.size());
		String deleted = testList.remove(9);
		Assert.assertEquals((9), testList.size());
		Assert.assertEquals("9", deleted);
		
		for(int i=0;i<9;i++) {
			deleted = testList.remove(0);
			Assert.assertEquals((9-i-1), testList.size());
			Assert.assertEquals(i, deleted);
		}
		
	}
}
