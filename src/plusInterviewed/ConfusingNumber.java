package plusInterviewed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConfusingNumber
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/confusing-number/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid. We can rotate digits of a number by
		 * 180 degrees to form new digits. When 0, 1, 6, 8, and 9 are rotated 180 degrees, they become 0, 1, 9, 8, and 6 respectively. When 2, 3, 4, 5, and 7
		 * are rotated 180 degrees, they become invalid. Note that after rotating a number, we can ignore leading zeros. For example, after rotating 8000, we
		 * have 0008 which is considered as just 8. Given an integer n, return true if it is a confusing number, or false otherwise.
		 * 
		 * Example 1: Input: n = 6 Output: true Explanation: We get 9 after rotating 6, 9 is a valid number, and 9 != 6. Example 2: Input: n = 89 Output: true
		 * Explanation: We get 68 after rotating 89, 68 is a valid number and 68 != 89. Example 3: Input: n = 11 Output: false Explanation: We get 11 after
		 * rotating 11, 11 is a valid number but the value remains the same, thus 11 is not a confusing number
		 * 
		 * Constraints: 0 <= n <= 10^9
		 */
		int[] examples = { 6, 89, 11, 916 };
		for (int i = 0; i < examples.length; i++)
		{
			System.out.println(confusingNumber(examples[i]));
		}
	}
	
	public static boolean confusingNumber(int num)
	{
		if (num == 0)
		{ return false; }
		String numStr = String.valueOf(num);
		int n = numStr.length();
		Set set = new HashSet<>(Arrays.asList('0', '1', '6', '8', '9', '1'));
		Map<Character, Character> map = Map.of('0', '0', '1', '1', '6', '9', '8', '8', '9', '6');
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++)
		{
			char ch = numStr.charAt(i);
			if (set.contains(ch))
			{
				sb.append(map.get(ch));
			}
			else
			{
				return false;
			}
		}
		char[] charArr = sb.toString().toCharArray();
		// reverse
		reverseString(charArr);
		// remove leading '0'
		int i = 0;
		while (charArr[i] == '0')
		{
			i++;
		}
		String newStr = String.copyValueOf(charArr);
		if (i > 0)
		{
			newStr = newStr.substring(i - 1, n - 1);
		}
		if (!newStr.equals(numStr)) return true;
		else
			return false;
	}
	
	public static void reverseString(char[] s)
	{
		int n = s.length;
		for (int left = 0, right = n - 1; left < right; left++, right--)
		{
			char ch = s[left];
			s[left] = s[right];
			s[right] = ch;
		}
	}
	
}
