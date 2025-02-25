package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TwoDArray
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		List<List<Integer>> arr = new ArrayList<>();
		
		for (int i = 0; i < 6; i++)
		{
			String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			
			List<Integer> arrRowItems = new ArrayList<>();
			
			for (int j = 0; j < 6; j++)
			{
				int arrItem = Integer.parseInt(arrRowTempItems[j]);
				arrRowItems.add(arrItem);
			}
			
			arr.add(arrRowItems);
		}
		
		bufferedReader.close();
		System.out.println(largestHourGlass(arr));
	}
	
	public static int largestHourGlass(List<List<Integer>> arr)
	{
		int maxSum = Integer.MIN_VALUE;
		int n = arr.size();
		for (int i = 1; i <= 4; i++)
		{
			for (int j = 1; j <= 4; j++)
			{
				int sum = arr.get(i).get(j) + arr.get(i - 1).get(j + 1) + arr.get(i + 1).get(j - 1) + arr.get(i - 1).get(j - 1) + arr.get(i + 1).get(j + 1) + arr.get(i).get(j - 1) + arr.get(i).get(j + 1);
				if (sum > maxSum)
				{
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}
}
