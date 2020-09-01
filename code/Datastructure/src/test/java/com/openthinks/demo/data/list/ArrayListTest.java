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
public class ArrayListTest {

	@Test
	public void testSize() {
		List<String> testList = new ArrayList<>();
		Assert.assertEquals(0, testList.size());
		testList.append("1");
		Assert.assertEquals(1, testList.size());
		testList.append("2");
		Assert.assertEquals(2, testList.size());
		for(int i=0;i<10;i++) {
			testList.append(String.valueOf(i+3));
		}
		Assert.assertEquals(12, testList.size());
	}
	
	@Test
	public void testInsert() {
		List<String> testList = new ArrayList<>();
		try {
			testList.insert(1, "a");
		} catch (Exception e) {
			Assert.assertTrue(e.getClass()==ArrayIndexOutOfBoundsException.class);
		}
		testList.insert(0,"a");
		Assert.assertEquals("a", testList.get(0));
		testList.insert(0,"b");
		Assert.assertEquals("b", testList.get(0));
		Assert.assertEquals("a", testList.get(1));
		testList.insert(1,"c");
		Assert.assertEquals(3, testList.size());
		Assert.assertEquals("c", testList.get(1));
		Assert.assertEquals("a", testList.get(2));
	}
	
	@Test
	public void testAppend() {
		List<String> testList = new ArrayList<>();
		testList.append("a");
		Assert.assertEquals(1, testList.size());
		Assert.assertEquals("a", testList.get(0));
		testList.append("b");
		Assert.assertEquals(2, testList.size());
		Assert.assertEquals("b", testList.get(1));
		testList.append("c");
		Assert.assertEquals(3, testList.size());
		Assert.assertEquals("c", testList.get(2));
	}
	
	
	@Test
	public void testRemove() {
		List<String> testList = new ArrayList<>();
		for(int i=0;i<30;i++) {
			testList.append(String.valueOf(i));
		}
		Assert.assertEquals(30, testList.size());
		for(int i=0;i<28;i++) {
			String deleted = testList.remove(0);
			Assert.assertEquals(String.valueOf(i), deleted);
			Assert.assertEquals((30-i-1), testList.size());
		}
		Assert.assertEquals(2, testList.size());
		Assert.assertEquals("28", testList.get(0));
	}
	
	@Test
	public void testEnsureCapacity() {
		ArrayList<String> testList = new ArrayList<>(18);
		for(int i=0;i<9;i++) {
			testList.append(String.valueOf(i));
			Assert.assertEquals(18, testList.capacity());
		}
		for(int i=0;i<9;i++) {
			testList.append(String.valueOf(i+9));
			Assert.assertEquals(18*2, testList.capacity());
		}
		
		
	}
}
