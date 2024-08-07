package plusInterviewed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidWordSquare
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/valid-word-square/?envType=study-plan-v2&envId=premium-algo-100
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
			mat[i] = Arrays.copyOf(chars, m);
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
