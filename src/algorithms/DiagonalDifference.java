package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DiagonalDifference
{
	public static int diagonalDifference(List<List<Integer>> arr)
	{
		int Right2LeftDiagonal = 0;
		int left2RightDiagonal = 0;
		int matSize = arr.size();
		for (int i = 0; i < matSize; i++)
		{
			Right2LeftDiagonal += arr.get(i).get(matSize - 1 - i);
			left2RightDiagonal += arr.get(i).get(i);
		}
		return Math.abs(Right2LeftDiagonal-left2RightDiagonal
				);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bufferedReader.readLine().trim());
		
		List<List<Integer>> arr = new ArrayList<>();
		
		IntStream.range(0, n).forEach(i -> {
			try
			{
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
			}
			catch (IOException ex)
			{
				throw new RuntimeException(ex);
			}
		});
		int result = DiagonalDifference.diagonalDifference(arr);
		System.out.println(result);
		
		bufferedReader.close();
	}
}
