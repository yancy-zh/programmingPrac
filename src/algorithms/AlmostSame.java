package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlmostSame
{
	
	public static void main(String[] args)
	{
		
	}
	
	public static List<String> areAlmostEquivalent(List<String> s, List<String> t)
	{
		List<String> out = new ArrayList<>();
		for (int i = 0; i < s.size(); i++)
		{
			String word1 = s.get(i);
			String word2 = t.get(i);
			if (checkAlmostEquivalent(word1, word2))
			{
				out.add("YES");
			}
			else
			{
				out.add("NO");
			}
			
		}
		
		return t;
		
	}
	
	public static boolean checkAlmostEquivalent(String word1, String word2)
	{
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch1 : word1.toCharArray())
		{
			map.put(ch1, map.getOrDefault(ch1, 0) + 1);
		}
		for (char ch2 : word2.toCharArray())
		{
			map.put(ch2, map.getOrDefault(ch2, 0) - 1);
		}
		for (int i : map.values())
		{
			if (Math.abs(i) > 3)
			{ return false; }
		}
		return true;
	}
}
