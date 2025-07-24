package hsbcMock;

import java.util.HashSet;

public class LargestConsecutiveSequence
{
	/**
	 * https://leetcode.cn/problems/WhsWhI/ LCR 119. 最长连续序列 中等 相关标签 相关企业 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 示例 1： 输入：nums = [100,4,200,1,3,2]
	 * https://leetcode.cn/problems/longest-consecutive-sequence/description/ 输出：4 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 示例 2： 输入：nums = [0,3,7,2,5,8,4,6,0,1] 输出：9
	 * 提示： 0 <= nums.length <= 104 -109 <= nums[i] <= 109
	 * 
	 * @param nums
	 * @return maxLen
	 */
	public int longestConsecutive(int[] nums)
	{
		int n = nums.length;
		if (n == 1 || n == 0)
		{ return n; }
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < n; i++)
		{
			hashSet.add(nums[i]);
		}
		int maxLen = 1;
		int currNum = 0;
		int currLen = 1;
		for (Integer integer : hashSet)
		{
			if (hashSet.contains(integer - 1))
			{
				continue;
			}
			currNum = integer;
			currLen = 1;
			while (hashSet.contains(currNum + 1))
			{
				currLen++;
				currNum++;
			}
			maxLen = currLen > maxLen ? currLen : maxLen;
		}
		
		return maxLen;
	}
}
