package plusInterviewed;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/palindrome-permutation/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * Given a string s, return true if a permutation of the string could form a palindrome and false otherwise.
		 * 
		 * Example 1: Input: s = "code" Output: false Example 2: Input: s = "aab" Output: true Example 3: Input: s = "carerac" Output: true
		 * 
		 * Constraints: 1 <= s.length <= 5000 s consists of only lowercase English letters.
		 */
		String s = "code";
		System.out.println(canPermutePalindrome(s));
	}
	
	public static boolean canPermutePalindrome(String s)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int n = s.length();
		for (int i = 0; i < n; i++)
		{
			char ch = s.charAt(i);
			if (!map.containsKey(ch))
			{
				map.put(ch, 1);
			}
			else
			{
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}
		}
		int cnt = 0;
		for (char key : map.keySet())
		{
			if (map.get(key) % 2 != 0)
			{
				cnt++;
			}
		}
		return cnt < 2;
	}
}
