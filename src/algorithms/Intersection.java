package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection
{
	public int[] findIntersection(int[] nums1, int[] nums2)
	{
		// if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
		// { return new int[0]; }
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> res = new ArrayList<>();
		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length)
		{
			if (nums1[i] == nums2[j])
			{
				res.add(nums1[i]);
				i++;
				j++;
			}
			else if (nums1[i] < nums2[j])
			{
				i++;
			}
			else
			{
				j++;
			}
		}
		// to array
		return arrayListToIntArray(res);
	}
	
	int[] arrayListToIntArray(List<Integer> arrayList)
	{
		return arrayList.stream().mapToInt(i -> i).toArray();
	}
}
