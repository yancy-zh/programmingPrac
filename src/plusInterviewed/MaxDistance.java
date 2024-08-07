package plusInterviewed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistance
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/maximum-distance-in-arrays/description/?envType=study-plan-v2&envId=premium-algo-100
		List<List<Integer>> arr = new ArrayList<List<Integer>>(Arrays.asList());
		arr.add(Arrays.asList(1, 2, 3));
		arr.add(Arrays.asList(4, 5));
		arr.add(Arrays.asList(1, 2, 3));
		System.out.println(maxDistance2(arr));
		arr.clear();
		arr.add(Arrays.asList(1));
		arr.add(Arrays.asList(1));
		System.out.println(maxDistance2(arr));
		arr.clear();
		arr.add(Arrays.asList(1, 5));
		arr.add(Arrays.asList(3, 4));
		System.out.println(maxDistance2(arr));
	}
	
	public static int maxDistance(List<List<Integer>> arrays)
	{
		int n = arrays.size();
		int max = 0;
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = i + 1; j < n; j++)
			{
				List<Integer> arr1 = arrays.get(i);
				List<Integer> arr2 = arrays.get(j);
				max = Math.max(max, Math.abs(arr1.get(0) - arr2.get(arr2.size() - 1)));
				max = Math.max(max, Math.abs(arr2.get(0) - arr1.get(arr1.size() - 1)));
			}
		}
		return max;
	}
	
	public static int maxDistance2(List<List<Integer>> arrays)
	{
		int max = 0;
		int n = arrays.get(0).size(); // init with the first arr size
		int minVal = arrays.get(0).get(0); // local min in all pre arrays
		int maxVal = arrays.get(0).get(n - 1); // local max in all pre arrays
		for (int i = 0; i < arrays.size(); i++)
		{
			n = arrays.get(i).size(); // update n by the curr array size
			max = Math.max(max, Math.abs(arrays.get(i).get(n - 1) - minVal));
			max = Math.max(max, Math.abs(maxVal - arrays.get(i).get(0)));
			minVal = Math.min(minVal, arrays.get(i).get(0));
			maxVal = Math.max(maxVal, arrays.get(i).get(n - 1));
		}
		return max;
	}
}
