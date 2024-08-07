package hsbcMock;

public class NumIslands
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/number-of-islands/
		
	}
	
	public static int numIslands(char[][] grid)
	{
		int cnt = 0;
		if (grid == null || grid.length == 0)
		{ return 0; }
		int nr = grid.length;
		int nc = grid[0].length;
		for (int i = 0; i < nr; i++)
		{
			for (int j = 0; j < nc; j++)
			{
				if (grid[i][j] == '1')
				{
					cnt++;
					dfs(grid, i, j);
				}
			}
		}
		return cnt;
	}
	
	public static void dfs(char[][] grid, int i, int j)
	{
		int nr = grid.length;
		int nc = grid[0].length;
		if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0')
		{ return; }
		grid[i][j] = '0';
		dfs(grid, i - 1, j);
		dfs(grid, i + 1, j);
		dfs(grid, i, j - 1);
		dfs(grid, i, j + 1);
	}
}
