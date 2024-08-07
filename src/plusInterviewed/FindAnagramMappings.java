package plusInterviewed;

import java.util.HashMap;
import java.util.Map;

import utils.MyPrinter;

public class FindAnagramMappings
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/find-anagram-mappings/description/?envType=study-plan-v2&envId=premium-algo-100
		int[] nums1 = { 12, 28, 46, 32, 50 };
		int[] nums2 = { 50, 12, 32, 46, 28 };
		MyPrinter.printPrimitiveInt(anagramMappings(nums1, nums2));
		int[] nums3 = { 84, 46 };
		int[] nums4 = { 84, 46 };
		MyPrinter.printPrimitiveInt(anagramMappings(nums3, nums4));
	}
	
	public static int[] anagramMappings(int[] nums1, int[] nums2)
	{
		int n = nums1.length;
		int[] mapping = new int[n];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++)
		{
			map.put(nums2[i], i);
		}
		for (int i = 0; i < n; i++)
		{
			mapping[i] = map.get(nums1[i]);
		}
		return mapping;
	}
}
