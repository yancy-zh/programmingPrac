package plusInterviewed;

import java.util.HashMap;

public class LargestUniqueNumber
{
	
	public static void main(String[] args)
	{
		// 1133. Largest Unique Number
		// https://leetcode.cn/problems/largest-unique-number/description/?envType=study-plan-v2&envId=premium-algo-100
		int[] nums = { 5, 7, 3, 9, 4, 9, 8, 3, 1 };
		System.out.println(largestUniqueNumber(nums));
		int[] nums1 = { 9, 9, 8, 8 };
		System.out.println(largestUniqueNumber(nums1));
	}
	
	public static int largestUniqueNumber(int[] nums)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
		{
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		int maxInt = -1;
		for (int key : map.keySet())
		{
			
			if (map.get(key) == 1)
			{
				if (key > maxInt)
				{
					maxInt = key;
				}
			}
		}
		return maxInt;
	}
}
