package plusInterviewed;

public class MaxConsecutiveOnces
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/max-consecutive-ones-ii/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
		 * 
		 * Example 1: Input: s = "eceba" Output: 3 Explanation: The substring is "ece" which its length is 3. Example 2: Input: s = "ccaabbb" Output: 5
		 * Explanation: The substring is "aabbb" which its length is 5.
		 * 
		 * Constraints: 1 <= s.length <= 105 s consists of English letters.
		 */
		int[] nums = { 1, 0, 1, 1, 0 };
		System.out.println(findMaxConsecutiveOnes(nums));
		int[] nums2 = { 1, 0, 1, 1, 0, 1 };
		System.out.println(findMaxConsecutiveOnes(nums2));
	}
	
	public static int findMaxConsecutiveOnes(int[] nums)
	{
		int maxCnt = 0;
		int n = nums.length;
		int dp0 = 0, dp1 = 0;
		for (int i = 0; i < n; ++i)
		{
			if (nums[i] == 1)
			{
				dp0++;
				dp1++;
			}
			else
			{
				dp0 = 0;
				dp1 = dp0 + 1;
			}
			maxCnt = Math.max(maxCnt, Math.max(dp0, dp1));
		}
		return maxCnt;
	}
}
