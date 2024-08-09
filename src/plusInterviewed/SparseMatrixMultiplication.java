package plusInterviewed;

public class SparseMatrixMultiplication
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/sparse-matrix-multiplication/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * Given two sparse matrices mat1 of size m x k and mat2 of size k x n, return the result of mat1 x mat2. You may assume that multiplication is always
		 * possible.
		 * 
		 * Example 1: Input: mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]] Output: [[7,0,0],[-7,0,3]] Example 2: Input: mat1 = [[0]], mat2 = [[0]]
		 * Output: [[0]]
		 * 
		 * Constraints: m == mat1.length k == mat1[i].length == mat2.length n == mat2[i].length 1 <= m, n, k <= 100 -100 <= mat1[i][j], mat2[i][j] <= 100
		 */
		int[][] mat11 = { { 1, 0, 0 }, { -1, 0, 3 } };
		int[][] mat12 = { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
		System.out.println(multiply(mat11, mat12));
		int[][] mat21 = { { 1, -5 } };
		int[][] mat22 = { { 12 }, { -1 } };
		System.out.println(multiply(mat21, mat22));
	}
	
	public static int[][] multiply(int[][] mat1, int[][] mat2)
	{
		int m = mat1.length;
		int k = mat1[0].length;
		int n = mat2[0].length;
		int[][] out = new int[m][n];
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				int sum = 0;
				for (int x = 0; x < k; x++)
				{
					sum += mat1[i][x] * mat2[x][j];
				}
				out[i][j] = sum;
			}
		}
		return out;
	}
}
