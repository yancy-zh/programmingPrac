package plusInterviewed;

import java.util.Arrays;

import utils.MyPrinter;

public class WiggleSort
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/wiggle-sort/description/?envType=study-plan-v2&envId=premium-algo-100
		int nums[] = { 3, 5, 2, 1, 6, 4 };
		wiggleSort(nums);
		MyPrinter.printPrimitiveInt(nums);
		int nums2[] = { 6, 6, 5, 6, 3, 8 };
		wiggleSort(nums2);
		MyPrinter.printPrimitiveInt(nums2);
	}
	
	public static void wiggleSort(int[] nums)
	{
		Arrays.sort(nums);
		for (int i = 1; i < nums.length - 1; i += 2)
		{
			swap(nums, i, i + 1);
		}
		
	}
	
	public static void swap(int[] nums, int i, int j)
	{
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
