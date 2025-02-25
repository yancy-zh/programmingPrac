package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import algorithms.FindKthLargest;

class FindKthLargestTest
{
	FindKthLargest sol = new FindKthLargest();
	
	@Test
	public void test1()
	{
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		int kth = sol.findKthLargest(nums, k);
		assertEquals(5, kth);
	}
	
	@Test
	public void test2()
	{
		int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		int kth = sol.findKthLargest(nums, k);
		assertEquals(4, kth);
	}
	
}
