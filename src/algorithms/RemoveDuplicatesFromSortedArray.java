package algorithms;

public class RemoveDuplicatesFromSortedArray
{
	
	public static void main(String[] args)
	{
		int[] nums = { 1, 1, 2, 2, 2, 3, 4, 5 };
		int k = 5;
		int res = removeDuplicates(nums);
		System.out.println(res == k);
	}
	
	public static int removeDuplicates(int[] nums)
	{
		int insertIndex = 1;
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i - 1] != nums[i])
			{
				nums[insertIndex] = nums[i];
				insertIndex++;
			}
		}
		return insertIndex;
	}
	
}
