package hsbcMock;

import java.util.Arrays;

public class MissingNum
{
	public int missingNumber(int[] nums)
	{
		// https://leetcode.cn/problems/missing-number-lcci/description/
		Arrays.sort(nums);
		int n = nums.length;
		// check if missing num is at the last index
		if (nums[n - 1] != n)
		{ return n; }
		// check if missing num is at the beginning
		if (nums[0] != 0)
		{ return 0; }
		int total = (1 + n) * n / 2;
		int sum = 0;
		for (int i : nums)
		{
			sum += i;
		}
		return total - sum;
	}
}
