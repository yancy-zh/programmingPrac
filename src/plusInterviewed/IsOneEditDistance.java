package plusInterviewed;

public class IsOneEditDistance
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/one-edit-distance/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * Given two strings s and t, return true if they are both one edit distance apart, otherwise return false. A string s is said to be one distance apart
		 * from a string t if you can: Insert exactly one character into s to get t. Delete exactly one character from s to get t. Replace exactly one character
		 * of s with a different character to get t.
		 * 
		 * Example 1: Input: s = "ab", t = "acb" Output: true Explanation: We can insert 'c' into s to get t. Example 2: Input: s = "", t = "" Output: false
		 * Explanation: We cannot get t from s by only one step.
		 * 
		 * Constraints: 0 <= s.length, t.length <= 104 s and t consist of lowercase letters, uppercase letters, and digits.
		 */
		String s = "ab", t = "acb";
		System.out.println(isOneEditDistance(s, t));
		s = "";
		t = "";
		System.out.println(isOneEditDistance(s, t));
		
	}
	
	public static boolean isOneEditDistance(String s, String t)
	{
		int ns = s.length(), nt = t.length();
		// 确保 s 比 t 短。
		if (ns > nt) return isOneEditDistance(t, s);
		// 如果长度差异大于1，则字符串不是一个编辑距离。
		if (nt - ns > 1) return false;
		if (nt == ns)
		{
			for (int i = 0; i < ns; i++)
			{
				if (s.charAt(i) != t.charAt(i))
				{ return s.substring(i + 1).equals(t.substring(i + 1)); }
			}
		}
		else
		{
			for (int i = 0; i < ns; i++)
			{
				if (s.charAt(i) != t.charAt(i))
				{ return s.substring(i).equals(t.substring(i + 1)); }
			}
		}
		return ns + 1 == nt;
	}
}
