package plusInterviewed;

import java.util.HashSet;
import java.util.Set;

public class CountingElements
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/counting-elements/description/?envType=study-plan-v2&envId=premium-algo-100
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
