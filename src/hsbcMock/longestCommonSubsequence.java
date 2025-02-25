package hsbcMock;

public class longestCommonSubsequence {
	/**
	 * 基因测序是生物信息学中的一个重要问题。给定两个基因序列 s1 和 s2，要求找到它们的最长公共子序列（Longest Common
	 * Subsequence, LCS）。最长公共子序列是指在两个序列中都出现的最长子序列，子序列中的字符不需要连续。 示例 输入: s1 =
	 * "AGGTAB", s2 = "GXTXAYB" 输出: 4 解释: 最长公共子序列是 "GTAB"，长度为 4。 解题思路
	 * 这是一个经典的动态规划问题。我们可以通过构建一个二维动态规划表来解决。 定义状态： 设 dp[i][j] 表示 s1 的前 i 个字符和 s2 的前 j
	 * 个字符的最长公共子序列的长度。 状态转移方程： 如果 s1[i-1] == s2[j-1]，则 dp[i][j] = dp[i-1][j-1] + 1。
	 * 如果 s1[i-1] != s2[j-1]，则 dp[i][j] = max(dp[i-1][j], dp[i][j-1])。 初始化： dp[0][j]
	 * = 0，表示 s1 为空时，最长公共子序列长度为 0。 dp[i][0] = 0，表示 s2 为空时，最长公共子序列长度为 0。 结果：
	 * dp[len(s1)][len(s2)] 即为最终结果。
	 */
	public int longestCommonSubsequence(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (s1.charAt(i - 1) == (s2.charAt(j - 1))) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}
}
