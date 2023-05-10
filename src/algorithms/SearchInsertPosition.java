package algorithms;

// binary search
public class SearchInsertPosition
{
	public static int searchInsert(int[] nums, int target)
	{
		int low = 0, high = nums.length-1;
		while (low <= high)
		{
			int middle = low + (high - low) / 2;
			if (nums[middle] == target)
			{
				return middle;
			}
			else if (target < nums[middle])
			{
				high = middle-1;
			} else {
				low = middle+1;
			}
			
		}
		return low;
	}
}
