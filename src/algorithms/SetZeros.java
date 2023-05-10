package algorithms;

public class SetZeros
{
	public int[][] setZeroes(int[][] matrix)
	{
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] cols = new boolean[n];
		boolean[] rows = new boolean[m];
		for (int i = 0; i < m; i++)
		{ // rows
			for (int j = 0; j < n; j++) // cols
			{
				if (matrix[i][j] == 0)
				{
					cols[i] = true;
					rows[j] = true;
				}
			}
		}
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (cols[i] || rows[j])
				{
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}
}
