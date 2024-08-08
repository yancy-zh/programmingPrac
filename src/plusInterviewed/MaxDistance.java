package plusInterviewed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistance
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/maximum-distance-in-arrays/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * You are given m arrays, where each array is sorted in ascending order. You can pick up two integers from two different arrays (each array picks one)
		 * and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a - b|. Return the maximum distance.
		 * 
		 * Example 1: Input: arrays = [[1,2,3],[4,5],[1,2,3]] Output: 4 Explanation: One way to reach the maximum distance 4 is to pick 1 in the first or third
		 * array and pick 5 in the second array. Example 2: Input: arrays = [[1],[1]] Output: 0
		 * 
		 * Constraints: m == arrays.length 2 <= m <= 105 1 <= arrays[i].length <= 500 -104 <= arrays[i][j] <= 104 arrays[i] is sorted in ascending order. There
		 * will be at most 105 integers in all the arrays.
		 */
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
