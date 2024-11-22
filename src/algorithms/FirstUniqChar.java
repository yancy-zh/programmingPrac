package algorithms;

import java.util.HashMap;

public class FirstUniqChar
{
	public int firstUniqChar(String s)
	{
		HashMap<Character, Integer> count = new HashMap();
		for (int i = 0; i < s.length(); i++)
		{
			Character character = s.charAt(i);
			count.put(character, count.getOrDefault(character, 0) + 1);
			
		}
		
		for (int i = 0; i < s.length(); i++)
		{
			if (count.get(s.charAt(i)) == 1) return i;
		}
		return -1;
	}
}
