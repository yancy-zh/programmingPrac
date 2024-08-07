package leetcode2024Top100;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=2024-spring-sprint-100
		
	}
	
	public static List<Integer> spiralOrder(int[][] matrix)
	{
		List<Integer> out = new ArrayList<>();
		int r = matrix.length;
		int c = matrix[0].length;
		if (matrix == null || r == 0 || c == 0)
		{ return out; }
		// 与输入矩阵大小相同的辅助矩阵 visited，其中的每个元素表示该位置是否被访问过
		boolean[][] visited = new boolean[r][c];
		// 顺时针旋转
		int[][] directions = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
		// 初始位置是矩阵的左上角，初始方向是向右, i loops in cols, j loops in rows.
		int i = 0, j = 0;
		int[] curr_direct = directions[0];
		// 如何判断路径是否结束？由于矩阵中的每个元素都被访问一次，因此路径的长度即为矩阵中的元素数量，当路径的长度达到矩阵中的元素数量时即为完整路径，将该路径返回
		int total = r * c;
		for (int k = 0; k < total; k++)
		{
			out.add(matrix[i][j]);
			visited[i][j] = true;
		}
		return out;
	}
	
}
