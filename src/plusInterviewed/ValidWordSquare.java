package plusInterviewed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidWordSquare
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/valid-word-square/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * Given an array of strings words, return true if it forms a valid word square. A sequence of strings forms a valid word square if the kth row and
		 * column read the same string, where 0 <= k < max(numRows, numColumns).
		 * 
		 * Example 1: Input: words = ["abcd","bnrt","crmy","dtye"] Output: true Explanation: The 1st row and 1st column both read "abcd". The 2nd row and 2nd
		 * column both read "bnrt". The 3rd row and 3rd column both read "crmy". The 4th row and 4th column both read "dtye". Therefore, it is a valid word
		 * square. Example 2: Input: words = ["abcd","bnrt","crm","dt"] Output: true Explanation: The 1st row and 1st column both read "abcd". The 2nd row and
		 * 2nd column both read "bnrt". The 3rd row and 3rd column both read "crm". The 4th row and 4th column both read "dt". Therefore, it is a valid word
		 * square. Example 3: Input: words = ["ball","area","read","lady"] Output: false Explanation: The 3rd row reads "read" while the 3rd column reads
		 * "lead". Therefore, it is NOT a valid word square.
		 * 
		 * Constraints: 1 <= words.length <= 500 1 <= words[i].length <= 500 words[i] consists of only lowercase English letters.
		 */
		List<String> words = new ArrayList<>(Arrays.asList("abcd", "bnrt", "crmy", "dtye"));
		System.out.println(validWordSquare(words));
		List<String> words2 = new ArrayList<>(Arrays.asList("abcd", "bnrt", "crm", "dt"));
		System.out.println(validWordSquare(words2));
		List<String> words3 = new ArrayList<>(Arrays.asList("ball", "area", "read", "lady"));
		System.out.println(validWordSquare(words3));
		List<String> words4 = new ArrayList<>(Arrays.asList("abc", "bde", "cefg"));
		System.out.println(validWordSquare(words4));
	}
	
	public static boolean validWordSquare(List<String> words)
	{
		int m = words.size();
		
		int n = words.get(0).toCharArray().length;
		char[][] mat = new char[m][m];
		if (n != m)
		{ return false; }
		for (int i = 0; i < m; i++)
		{
			char[] chars = words.get(i).toCharArray();
			n = chars.length;
			if (n > m)
			{ return false; }
			mat[i] = Arrays.copyOf(chars, m);// ensure the same size each row
		}
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < m; j++)
			{
				if (mat[i][j] != mat[j][i])
				{ return false; }
			}
		}
		return true;
	}
}
