package algorithms;

public class RotateStringMatrix
{
	
//	public static void main(String[] args)
//	{
//		// TODO Auto-generated method stub
//		 String[] matrix = { "*..", ".*.", "..*" };
//		// String[] matrix = {
//		// "###.....",
//		// "..###...",
//		// "....###.",
//		// ".....###",
//		// ".....###",
//		// "....###.",
//		// "..###...",
//		// "###....."
//		// };
////		String[] matrix = { "a", "b", "c" };
////		String[] matrix = { "abc" };
////		String[] matrix = { "abc" };
//		
//		System.out.println("old mat");
//		printMatrix(matrix);
//		System.out.println("new mat");
//		printMatrix(rotate(matrix));
//	}
	
	public String[] rotate(String[] matrix)
	{
		int width = matrix.length;
		if (width == 0)
		{
			return new String[]{};
		}
		int height = matrix[0].length();
		char[][] charMatrix = new char[height][width];
		for (int i = 0; i < height; i++)
		{
			for (int j = 0; j < width; j++)
			{
				charMatrix[i][j] = matrix[width - j - 1].charAt(i);
			}
		}
		String[] newMatrix = charArrToStringMatrix(charMatrix);
		return newMatrix;
		
	}
	
	public static void printMatrix(String[] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			System.out.println(matrix[i]);
		}
	}
	
	public static String[] charArrToStringMatrix(char[][] charArr)
	{
		String[] resMatrix = new String[charArr.length];
		for (int i = 0; i < resMatrix.length; i++)
		{
			resMatrix[i] = String.valueOf(charArr[i]);
		}
		return resMatrix;
	}
}
