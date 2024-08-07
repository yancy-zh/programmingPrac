package plusInterviewed;

import java.util.HashSet;
import java.util.Set;

public class FindKLengthSubstrWORepeatedChars
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/find-k-length-substrings-with-no-repeated-characters/?envType=study-plan-v2&envId=premium-algo-100
		String s = "havefunonleetcode";
		int k = 5;
		System.out.println(numKLenSubstrNoRepeats(s, k));
		String s1 = "home";
		k = 5;
		System.out.println(numKLenSubstrNoRepeats(s1, k));
		
	}
	
	public static int numKLenSubstrNoRepeats(String s, int k)
	{
		if (k > 26)
		{ return 0; }
		int n = s.length();
		int left = 0, right = 0;
		Set<Character> set = new HashSet<>();
		int cnt = 0;
		while (right < n)
		{
			char ch = s.charAt(right);
			while (left <= right && set.contains(ch))
			{
				set.remove(s.charAt(left));
				left++;
			}
			set.add(ch);
			if (right - left + 1 == k)
			{
				cnt++;
				set.remove(s.charAt(left));
				left++;
			}
			right++;
		}
		return cnt;
	}
}
