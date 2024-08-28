package plusInterviewed;

import java.util.HashMap;
import java.util.Map;

public class CheckIfaNumberIsMajorityElementinSortedArr
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/check-if-a-number-is-majority-element-in-a-sorted-array/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * 1150. Check If a Number Is Majority Element in a Sorted Array Given an integer array nums sorted in non-decreasing order and an integer target,
		 * return true if target is a majority element, or false otherwise. A majority element in an array nums is an element that appears more than nums.length
		 * / 2 times in the array.
		 * 
		 * Example 1: Input: nums = [2,4,5,5,5,5,5,6,6], target = 5 Output: true Explanation: The value 5 appears 5 times and the length of the array is 9.
		 * Thus, 5 is a majority element because 5 > 9/2 is true. Example 2: Input: nums = [10,100,101,101], target = 101 Output: false Explanation: The value
		 * 101 appears 2 times and the length of the array is 4. Thus, 101 is not a majority element because 2 > 4/2 is false.
		 * 
		 * Constraints: 1 <= nums.length <= 1000 1 <= nums[i], target <= 109 nums is sorted in non-decreasing order.
		 */
		int[] nums = { 2, 4, 5, 5, 5, 5, 5, 6, 6 };
		int target = 5;
		System.out.println(isMajorityElement(nums, target));
		int[] nums2 = { 10, 100, 101, 101 };
		int target2 = 101;
		System.out.println(isMajorityElement(nums2, target2));
	}
	
	public static boolean isMajorityElement1(int[] nums, int target)
	{
		final int n = nums.length;
		if (n == 0)
		{ return false; }
		if (n == 1 && target == nums[0])
		{ return true; }
		Map<Integer, Integer> freqMap = new HashMap<>();
		final int FREQ = n / 2;
		for (int num : nums)
		{
			if (!freqMap.containsKey(num))
			{
				freqMap.put(num, 1);
			}
			else
			{
				freqMap.put(num, freqMap.get(num) + 1);
			}
		}
		if (!freqMap.containsKey(target))
		{ return false; }
		if (freqMap.get(target) > FREQ)
		{ return true; }
		return false;
	}
	
	public static boolean isMajorityElement(int[] nums, int target)
	{
		final int n = nums.length;
		int cnt = 0;
		for (int i = 0; i < n; i++)
		{
			if (nums[i] == target)
			{
				cnt++;
			}
			else if (nums[i] > target)
			{
				break;
			}
		}
		return cnt > n / 2;
	}
}
