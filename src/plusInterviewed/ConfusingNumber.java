package plusInterviewed;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConfusingNumber
{
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
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
