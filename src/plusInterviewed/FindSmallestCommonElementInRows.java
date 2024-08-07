package plusInterviewed;

public class FindSmallestCommonElementInRows
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/find-smallest-common-element-in-all-rows/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows. If there is no
		 * common element, return -1.
		 * 
		 * Example 1: Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]] Output: 5 Example 2: Input: mat = [[1,2,3],[2,3,4],[2,3,5]] Output: 2
		 * 
		 * Constraints: m == mat.length n == mat[i].length 1 <= m, n <= 500 1 <= mat[i][j] <= 104 mat[i] is sorted in strictly increasing order.
		 */
		int[][] mat = { { 1, 2, 3, 4, 5 }, { 2, 4, 5, 8, 10 }, { 3, 5, 7, 9, 11 }, { 1, 3, 5, 7, 9 } };
		System.out.println(smallestCommonElement(mat));
		int[][] mat1 = { { 1, 2, 10000 }, { 3, 4, 10000 }, { 5, 6, 10000 } };
		System.out.println(smallestCommonElement(mat1));
	}
	
	public static int smallestCommonElement(int[][] mat)
	{
		int[] cnt = new int[10001];// 数组序号默认从‘0’开始，存储10000需要有10001个数字。
		int m = mat.length;
		int n = mat[0].length;
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				cnt[mat[i][j]]++;
			}
		}
		for (int k = 0; k < cnt.length; k++)
		{
			if (cnt[k] == m)
			{ return k; }
		}
		return -1;
	}
}
