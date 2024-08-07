package hsbcMock;

import java.util.HashSet;

public class LongestStreak
{
	public static void main(String[] args)
	{
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(nums));// 4
		int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(nums2));// 9
	}
	
	public static int longestConsecutive(int[] nums)
	{
		if (nums.length == 0)
		{ return 0; }
		// https://leetcode.cn/problems/WhsWhI/description/
		HashSet<Integer> numSet = new HashSet<>();
		// put all nums in the array in a hashset
		for (int i : nums)
		{
			numSet.add(i);
		}
		int currentNum = 0;
		int currentStreakLen = 1;
		int longestStreakLen = currentStreakLen;
		for (int num : numSet)
		{
			if (numSet.contains(num - 1))
			{
				continue;
			}
			// use a var to record the num during numerating
			currentStreakLen = 1;
			currentNum = num;
			while (numSet.contains(currentNum + 1))
			{// enumerate with increment 1 from currentnum
				currentNum += 1;
				currentStreakLen += 1;
			}
			longestStreakLen = Math.max(currentStreakLen, longestStreakLen);
		}
		return longestStreakLen;
	}
}
