package plusInterviewed;

import java.util.HashSet;
import java.util.Set;

public class CountingElements
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/counting-elements/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * Given an integer array arr, count how many elements x there are, such that x + 1 is also in arr. If there are duplicates in arr, count them
		 * separately.
		 * 
		 * Example 1: Input: arr = [1,2,3] Output: 2 Explanation: 1 and 2 are counted cause 2 and 3 are in arr. Example 2: Input: arr = [1,1,3,3,5,5,7,7]
		 * Output: 0 Explanation: No numbers are counted, cause there is no 2, 4, 6, or 8 in arr.
		 * 
		 * Constraints: 1 <= arr.length <= 1000 0 <= arr[i] <= 1000
		 */
		int[] arr = { 1, 2, 3 };
		System.out.println(countElements(arr));
		int[] arr2 = { 1, 1, 3, 3, 5, 5, 7, 7 };
		System.out.println(countElements(arr2));
	}
	
	public static int countElements(int[] arr)
	{
		Set<Integer> set = new HashSet<>();
		for (int num : arr)
		{
			set.add(num);
		}
		int cnt = 0;
		for (int num : arr)
		{
			if (set.contains(num + 1))
			{
				cnt++;
			}
		}
		return cnt;
	}
}
