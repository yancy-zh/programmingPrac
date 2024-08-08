package plusInterviewed;

public class PerformStringShifts
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/perform-string-shifts/solutions/2425813/zhuan-hua-wei-yi-bu-you-yi-jie-qu-zi-fu-nkxcv/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [directioni, amounti]: directioni can be 0 (for
		 * left shift) or 1 (for right shift). amounti is the amount by which string s is to be shifted. A left shift by 1 means remove the first character of s
		 * and append it to the end. Similarly, a right shift by 1 means remove the last character of s and add it to the beginning. Return the final string
		 * after all operations.
		 * 
		 * Example 1: Input: s = "abc", shift = [[0,1],[1,2]] Output: "cab" Explanation: [0,1] means shift to left by 1. "abc" -> "bca" [1,2] means shift to
		 * right by 2. "bca" -> "cab" Example 2: Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]] Output: "efgabcd" Explanation: [1,1] means shift to
		 * right by 1. "abcdefg" -> "gabcdef" [1,1] means shift to right by 1. "gabcdef" -> "fgabcde" [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
		 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
		 * 
		 * Constraints: 1 <= s.length <= 100 s only contains lower case English letters. 1 <= shift.length <= 100 shift[i].length == 2 directioni is either 0 or
		 * 1. 0 <= amounti <= 100
		 */
		String s = "abc";
		int[][] shift = { { 0, 1 }, { 1, 2 } };
		System.out.println(stringShift(s, shift));
		s = "abcdefg";
		int[][] shift1 = { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } };
		System.out.println(stringShift(s, shift1));
		s = "joiazl";
		int[][] shift2 = { { 1, 1 }, { 1, 6 }, { 0, 1 }, { 1, 3 }, { 1, 0 }, { 0, 3 } };
		System.out.println(stringShift(s, shift2));
		s = "wpdhhcj";
		int[][] shift3 = { { 0, 7 }, { 1, 7 }, { 1, 0 }, { 1, 3 }, { 0, 3 }, { 0, 6 }, { 1, 2 } };
		System.out.println(stringShift(s, shift3));
	}
	
	public static String stringShift(String s, int[][] shift)
	{
		String out = s;
		int offset = 0;
		int n = shift.length;
		int m = s.length();
		for (int i = 0; i < n; i++)
		{
			if (shift[i][0] == 0)
			{
				offset -= shift[i][1];
			}
			else
			{
				offset += shift[i][1];
			}
		}
		offset = offset % m;
		if (offset > 0)// shift right
		{
			out = s.substring(m - Math.abs(offset)) + s.substring(0, m - Math.abs(offset));
		}
		else if (offset < 0)// shift left
		{
			
			out = s.substring(Math.abs(offset), m) + s.substring(0, Math.abs(offset));
		}
		return out;
	}
}
