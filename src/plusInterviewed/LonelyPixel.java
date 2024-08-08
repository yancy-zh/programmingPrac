package plusInterviewed;

public class LonelyPixel
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/lonely-pixel-i/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * Given an m x n picture consisting of black 'B' and white 'W' pixels, return the number of black lonely pixels. A black lonely pixel is a character
		 * 'B' that located at a specific position where the same row and same column don't have any other black pixels.
		 * 
		 * Example 1: Input: picture = [["W","W","B"],["W","B","W"],["B","W","W"]] Output: 3 Explanation: All the three 'B's are black lonely pixels. Example 2:
		 * Input: picture = [["B","B","B"],["B","B","W"],["B","B","B"]] Output: 0
		 * 
		 * Constraints: m == picture.length n == picture[i].length 1 <= m, n <= 500 picture[i][j] is 'W' or 'B'.
		 */
		char[][] picture = { { 'W', 'W', 'B' }, { 'W', 'B', 'W' }, { 'B', 'W', 'W' } };
		System.out.println(findLonelyPixel(picture));
		char[][] pic2 = { { 'B', 'B', 'B' }, { 'B', 'B', 'W' }, { 'B', 'B', 'B' } };
		System.out.println(findLonelyPixel(pic2));
		char[][] pic3 = { { 'B', 'B', 'B' } };
		System.out.println(findLonelyPixel(pic3));
	}
	
	public static int findLonelyPixel(char[][] picture)
	{
		int cnt = 0;// count of lonely 'B'
		int m = picture.length;
		int n = picture[0].length;
		int[] numB_in_rows = new int[m];
		int[] numB_in_cols = new int[n];
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (picture[i][j] == 'B')
				{
					numB_in_rows[i]++;
					numB_in_cols[j]++;
				}
			}
		}
		for (int x = 0; x < m; x++)
		{
			if (numB_in_rows[x] == 1)
			{
				for (int y = 0; y < n; y++)
				{
					if (numB_in_cols[y] == 1 && picture[x][y] == 'B')
					{
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
