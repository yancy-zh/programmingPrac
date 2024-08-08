package plusInterviewed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings
{
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/group-shifted-strings/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows. If there is no
		 * common element, return -1.
		 * 
		 * Example 1: Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]] Output: 5 Example 2: Input: mat = [[1,2,3],[2,3,4],[2,3,5]] Output: 2
		 * 
		 * Constraints: m == mat.length n == mat[i].length 1 <= m, n <= 500 1 <= mat[i][j] <= 104 mat[i] is sorted in strictly increasing order.
		 */
		String[] strs = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };
		for (List<String> e : groupStrings(strs))
		{
			System.out.println(String.join(" ", e));
		}
	}
	
	public static List<List<String>> groupStrings(String[] strings)
	{
		Arrays.sort(strings);
		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> grouped = new ArrayList<List<String>>();
		for (String s : strings)
		{
			int[] delta_ls = getGroup(s);
			String key = Arrays.toString(delta_ls);
			List<String> str_group = map.getOrDefault(key, new ArrayList<String>());
			str_group.add(s);
			map.put(key, str_group);
		}
		for (String key : map.keySet())
		{
			grouped.add(map.get(key));
		}
		return grouped;
	}
	
	public static int[] getGroup(String string)
	{
		int n = string.length();
		int[] delta_ls = new int[n - 1];
		for (int i = 1; i < n; i++)
		{
			int delta = string.charAt(i) - string.charAt(i - 1);
			if (delta < 0)
			{
				delta += 26;
			}
			delta_ls[i - 1] = delta;
		}
		return delta_ls;
	}
}
