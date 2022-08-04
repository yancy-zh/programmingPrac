package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pangrams
{
	private HashSet<Character> set = new HashSet<>();
	
	public static void main(String[] args)
	{
		String[] temp = { "we promptly judged antique ivory buckles for the next prize",
				"we promptly judged antique ivory buckles for the prizes",
				 "the quick brown fox jumps over the lazy dog",
				 "the quick brown fox jump over the lazy dog" };
		List<String> inStrs = Arrays.asList(temp);
		System.out.println(isPangram3(inStrs));
	}
	
	public static String isPangram(List<String> pangram)
	{// didn't pass all test cases
		StringBuilder outStr = new StringBuilder();
		for (String string : pangram)
		{
			if (string.length() > 25 && string.toLowerCase().chars().filter(i -> i < 'z' && i > 'a').distinct().count() == 26)
			{
				outStr.append("1");
			}
			else
			{
				outStr.append("0");
			}
		}
		return outStr.toString();
	}
	
	public static String isPangram3(List<String> pangram) {
		final StringBuilder result = new StringBuilder();

		for (String str : pangram) {
			int cnt = 0;
			boolean isPangram = false;
			Set<Integer> alphabet = new HashSet<Integer>(26);

			for (char c : str.toLowerCase().toCharArray()) {
				int n = c - 'a';
				if (n >= 0 && n < 26) {
					if (alphabet.add(n)) {
						cnt += 1;
						if (cnt == 26) {
							isPangram = true;
							break;
						}
					}
				}
			}

			if (isPangram) {
				result.append("1");
			} else {
				result.append("0");
			}
		}

		return result.toString();
	}
}
