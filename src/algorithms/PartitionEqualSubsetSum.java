package algorithms;

public class PartitionEqualSubsetSum {
	// 背包问题
	/*
	 * 01背包 416. 分割等和子集
	 * 
	 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
	 * 
	 * 示例 1：
	 * 
	 * 输入：nums = [1,5,11,5] 输出：true 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
	 * 
	 * 提示：
	 * 
	 * 1 <= nums.length <= 200 1 <= nums[i] <= 100 思路：本题要求把数组分成两个等和的子集，相当于找到一个子集，其和为
	 * sum / 2，这个 sum / 2 就是 target（target 间接给出）。 于是转化为是否可以用 nums 中的数组合和成 target，01
	 * 背包问题（组合），外层循环为选择池 num: nums，内层循环为 target。
	 */
	public boolean canPartition(int[] nums) {
		int n = nums.length;
		if (n < 2) {
			return false;
		}
		int sum = 0, maxNum = 0;
		for (int num : nums) {
			maxNum = Math.max(num, maxNum);
			sum += num;
		}
		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;
		if (maxNum > target) {
			return false;
		}
		boolean[] dp = new boolean[target + 1];
		dp[0] = true;
		for (int num : nums) {
			for (int i = target; i > 0; i--) {
				if (i >= num) {
					dp[i] = dp[i] || dp[i - num];
				}
			}
		}
		return dp[target];
	}
}
