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
