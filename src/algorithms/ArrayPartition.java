package algorithms;

import java.util.Arrays;

public class ArrayPartition
{
	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3, 4 };
		arrayPairSum(array);
	}
	
	public static int arrayPairSum(int[] nums)
	{
		Arrays.sort(nums);
		int[] evenNums = new int[nums.length / 2];
		int sum = 0;
		for (int i = 0; i < nums.length; i++)
		{
			if ((i + 1) % 2 == 1)
			{
				sum += nums[i];
				evenNums[(i + 1) / 2] = nums[i];
			}
		}
		System.out.println("the sum is: " + sum);
		System.out.println("selected mins are: ");
		Arrays.stream(evenNums).forEach(System.out::println);
		return sum;
	}
}
