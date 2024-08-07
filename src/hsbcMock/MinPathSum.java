package hsbcMock;

public class MinPathSum
{
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/minimum-path-sum/description/
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		System.out.println(minPathSum(grid));
	}
	
	public static int minPathSum(int[][] grid)
	{
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++)
		{
			// init the val for first col
			dp[i][0] = 0;
			for (int x = 0; x <= i; x++)
			{
				dp[i][0] += grid[x][0];
			}
		}
		for (int j = 0; j < n; j++)
		{
			// init the val for first row
			dp[0][j] = 0;
			for (int x = 0; x <= j; x++)
			{
				dp[0][j] += grid[0][x];
			}
		}
		for (int i = 1; i < m; i++)
		{
			for (int j = 1; j < n; j++)
			{
				dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
			}
		}
		return dp[m - 1][n - 1];
	}
	
}
