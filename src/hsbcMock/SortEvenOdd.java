package hsbcMock;

import java.util.Arrays;

import utils.MyPrinter;

public class SortEvenOdd
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/sort-even-and-odd-indices-independently/description/?envType=problem-list-v2&envId=xvuz7ici
		int[] nums = { 4, 1, 3, 3, 2, 5, 1 };
		MyPrinter.printPrimitiveInt(sortEvenOdd(nums));
	}
	
	public static int[] sortEvenOdd(int[] nums)
	{
		int n = nums.length;
		int[] sorted = new int[n];
		if (n % 2 == 0)
		{
			int[] even = new int[n / 2];
			int[] odd = new int[n / 2];
			for (int i = 0; i < n / 2; i++)
			{
				even[i] = nums[2 * i];
				odd[i] = nums[2 * i + 1];
			}
			Arrays.sort(even);
			System.out.println("even");
			MyPrinter.printPrimitiveInt(even);
			Arrays.sort(odd);
			odd = MyPrinter.reversePrimitiveArray(odd);
			System.out.println("odd");
			MyPrinter.printPrimitiveInt(odd);
			for (int i = 0; i < n / 2; i++) // merge
			{
				sorted[2 * i] = even[i];
				sorted[2 * i + 1] = odd[i];
			}
		}
		else
		{
			int[] even = new int[n / 2 + 1];
			int[] odd = new int[n / 2];
			for (int i = 0; i < n / 2; i++)
			{
				even[i] = nums[2 * i];
				odd[i] = nums[2 * i + 1];
			}
			even[n / 2] = nums[n - 1];
			Arrays.sort(even);
			System.out.println("even");
			MyPrinter.printPrimitiveInt(even);
			Arrays.sort(odd);
			odd = MyPrinter.reversePrimitiveArray(odd);
			System.out.println("odd");
			MyPrinter.printPrimitiveInt(odd);
			for (int i = 0; i < n / 2; i++)
			{
				sorted[2 * i] = even[i];
				sorted[2 * i + 1] = odd[i];
			}
			sorted[n - 1] = even[n / 2];
		}
		return sorted;
	}
	
}
