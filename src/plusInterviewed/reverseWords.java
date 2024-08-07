package plusInterviewed;

import utils.MyPrinter;

public class reverseWords
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/reverse-words-in-a-string-ii/solutions/2416792/fan-zhuan-zi-fu-chuan-zhong-de-dan-ci-ii-wzli/?envType=study-plan-v2&envId=premium-algo-100
		char[] s = { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
		reverseWords(s);
		MyPrinter.printPrimitiveCharArr(s);
	}
	
	public static void reverseWords(char[] s)
	{
		// reverse the whole char set.
		int n = s.length;
		reverseStringWP(s, 0, n - 1);
		int slow = 0, fast = 0;
		while (slow < n && fast < n)
		{
			while (fast < n && s[fast] != ' ')
			{
				fast++;
			}
			reverseStringWP(s, slow, fast - 1);
			slow = fast + 1;
			fast++;
		}
	}
	
	public static void reverseStringWP(char[] s, int start, int end)
	{
		int n = s.length;
		for (int left = start, right = end; left < right; left++, right--)
		{
			char ch = s[left];
			s[left] = s[right];
			s[right] = ch;
		}
	}
}
