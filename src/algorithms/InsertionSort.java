package algorithms;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort
{
	/*
	 * Complete the 'insertionSort2' function below.
	 *
	 * The function accepts following parameters: 1. INTEGER n 2. INTEGER_ARRAY arr
	 */
	public static List<Integer> arr = new ArrayList(List.of(2, 4, 6, 8, 3));
	
	public static void main(String[] args)
	{
		insertionSort1(arr.size(), arr);
	}
	
	public static void insertionSort1(int n, List<Integer> arr)
	{
		if (n <= 1)
		{ return; }
		insertionSort1(n - 1, arr);
		int stored = arr.get(n - 1);
		int i = n - 2;
		while (i >= 0 && arr.get(i) > stored)
		{
			arr.set(i + 1, arr.get(i));
			i--;
		}
		arr.set(i + 1, stored);
		printArr(arr);
	}
	
	public static void printArr(List<Integer> arr)
	{
		arr.forEach(e -> System.out.print(e + " "));
		System.out.println();
	}
}
