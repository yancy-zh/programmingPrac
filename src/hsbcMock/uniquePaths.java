package hsbcMock;

public class uniquePaths
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/unique-paths/solutions/514311/bu-tong-lu-jing-by-leetcode-solution-hzjf/
		int m = 3;
		int n = 7;
		System.out.println(uniquePaths(m, n));
		
	}
	
	public static int uniquePaths(int m, int n)
	{
		// m and n are num of rows and num of cols
		int[][] dp = new int[m][n];
		for (int j = 0; j < m; j++)
		{
			dp[j][0] = 1;
		}
		for (int i = 0; i < n; i++)
		{
			dp[0][i] = 1;
		}
		for (int j = 1; j < m; ++j)
		{
			for (int i = 1; i < n; ++i)
			{
				dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
}
