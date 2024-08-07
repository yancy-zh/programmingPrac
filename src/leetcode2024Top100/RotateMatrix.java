package leetcode2024Top100;

public class RotateMatrix
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=2024-spring-sprint-100
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(mat);
	}
	
	public static int[][] rotate(int[][] mat)
	{
		int m = mat.length; // num of rows
		int n = mat[0].length; // num of cols
		int temp;
		// get the transposition of the matrix, formula mat[i][j] = mat[j][i]
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		// get the vertical flip of the mat, which means mat[i][j] <=> mat[i][len-j-1]
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				temp = mat[i][j];
				mat[i][j] = mat[i][m - j - 1];
				mat[i][m - j - 1] = temp;
			}
		}
		return mat;
	}
}
