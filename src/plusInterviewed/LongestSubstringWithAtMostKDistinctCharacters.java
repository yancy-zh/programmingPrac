package plusInterviewed;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/longest-substring-with-at-most-k-distinct-characters/description/?envType=study-plan-v2&envId=premium-algo-100
		String string = "eceba";
		System.out.println(lengthOfLongestSubstringKDistinct(string, 2));
		string = "aa";
		System.out.println(lengthOfLongestSubstringKDistinct(string, 1));
		
	}
	
	public static int lengthOfLongestSubstringKDistinct(String s, int k)
	{
		int n = s.length();
		if (n < k + 1)
		// 如果字符串长度 N 小于 k，则返回 N。
		{ return n; }
		// 将两个指针都设置在字符串开始 left = 0 和 right = 0 的位置，初始化最大子字符串长度 maxlen = 2。
		int left = 0;
		int right = 0;
		int maxLen = k;
		Map<Character, Integer> table = new HashMap<Character, Integer>();
		while (right < n && left <= right)
		{
			char rch = s.charAt(right);
			table.put(rch, right);
			right++;
			if (table.keySet().size() == k + 1)
			{
				// 从哈希表中删除最左侧的字符 并移动 left 指针
				int toRemove = Collections.min(table.values());
				table.remove(s.charAt(toRemove));
				left = toRemove + 1;
			}
			maxLen = Math.max(maxLen, right - left);
		}
		return maxLen;
	}
}
