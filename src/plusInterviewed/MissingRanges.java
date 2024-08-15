package plusInterviewed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/missing-ranges/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range. A number x
		 * is considered missing if x is in the range [lower, upper] and x is not in nums. Return the shortest sorted list of ranges that exactly covers all the
		 * missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.
		 * 
		 * Example 1: Input: nums = [0,1,3,50,75], lower = 0, upper = 99 Output: [[2,2],[4,49],[51,74],[76,99]] Explanation: The ranges are: [2,2] [4,49]
		 * [51,74] [76,99] Example 2: Input: nums = [-1], lower = -1, upper = -1 Output: [] Explanation: There are no missing ranges since there are no missing
		 * numbers. Constraints: -109 <= lower <= upper <= 109 0 <= nums.length <= 100 lower <= nums[i] <= upper All the values of nums are unique.
		 */
		int[] nums = { 0, 1, 3, 50, 75 };
		int lower = 0;
		int upper = 99;
		System.out.println(findMissingRanges(nums, lower, upper));
		int[] nums2 = {};
		int lower2 = 1;
		int upper2 = 1;
		System.out.println(findMissingRanges(nums2, lower2, upper2));
		int[] nums3 = { -1 };
		int lower3 = -2;
		int upper3 = -1;
		System.out.println(findMissingRanges(nums3, lower3, upper3));
		int[] nums4 = { -1 };
		int lower4 = -1;
		int upper4 = -1;
		System.out.println(findMissingRanges(nums4, lower4, upper4));
		int[] nums5 = { 1, 2 };
		int lower5 = 0;
		int upper5 = 9;
		System.out.println(findMissingRanges(nums5, lower5, upper5));
	}
	
	public static List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper)
	{
		List<List<Integer>> ranges = new ArrayList<List<Integer>>();
		int n = nums.length;
		if (n == 0)
		{
			ranges.add(new ArrayList<>(Arrays.asList(lower, upper)));
			return ranges;
		}
		if (n == 1)// e.g. nums == {-1}
		{
			int curr = nums[0];
			if (curr == lower && curr == upper)
			{
				return ranges;
			}
			else if (curr > lower && curr < upper)
			{
				ranges.add(new ArrayList<>(Arrays.asList(lower, curr - 1)));
				ranges.add(new ArrayList<>(Arrays.asList(curr + 1, upper)));
			}
			else if (curr == lower)
			{
				ranges.add(new ArrayList<>(Arrays.asList(lower + 1, upper)));
			}
			else if (curr == upper)
			{
				ranges.add(new ArrayList<>(Arrays.asList(lower, upper - 1)));
			}
			return ranges;
		}
		for (int i = 0; i < n - 1; i++)
		{
			int curr = nums[i];
			int next = nums[i + 1];
			if (i == 0)// when nums[i] is the first num in the nums, considering adding the range btw nums[i] and lower,if it exists
			{
				if (curr - 1 > lower) // add a range
				{
					ranges.add(new ArrayList<>(Arrays.asList(lower, curr - 1)));
				}
				if (curr - 1 == lower) // add a num
				{
					ranges.add(new ArrayList<>(Arrays.asList(lower, lower)));
				}
			}
			
			if (curr >= lower && next <= upper && curr + 1 <= (next - 1)) // when nums[i] is not the first nor the last
			{
				ranges.add(new ArrayList<>(Arrays.asList(curr + 1, next - 1)));
			}
			
		}
		if (nums[n - 1] + 1 < upper)// when nums[i] is the last
		{
			ranges.add(new ArrayList<>(Arrays.asList(nums[n - 1] + 1, upper)));
		}
		if (nums[n - 1] + 1 == upper)
		{
			ranges.add(new ArrayList<>(Arrays.asList(upper, upper)));
		}
		return ranges;
	}
}
