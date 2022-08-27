package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JieLong
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int index = Integer.parseInt(scanner.nextLine()); // index in the array
		int N = Integer.parseInt(scanner.nextLine()); // num of words
		List<String> listWords = new ArrayList<String>();
		for (int i = 0; i < N; i++)
		{
			listWords.add(scanner.nextLine());
		}
		String head = listWords.get(index);
		List<String> outwords = new ArrayList<>();
		// add the first word
		outwords.add(head);
		// remove the first word from candidates
		listWords.remove(head);
		// loop 
		// find the next word
		String chosen = new String();
		while (true) {
			for (String string : listWords)
			{
				if (isNextWord(head, string))
				{
					if (chosen.isEmpty())
					{
						// found the first
						chosen = string;
					} else {
						if (string.length() > chosen.length()) // replace the old if the curr has a longer length
						{
							chosen = string;
						} else if (chkZiDianXu(string, chosen) == -1) {  // if len are the same,  string has a smaller lexicographical order, replace
							chosen = string;
						}
					}
				}
			}
			if (chosen.isEmpty())
			{
				// no suitable word is found
				outwords.forEach(System.out::println);
				break;
			}
			// append the chosen
			outwords.add(chosen);
			// delete the chosen 
			listWords.remove(chosen);
			// set the new head
			head = chosen;
		}
	}
	
	public static  boolean isNextWord(String word1, String word2)
	{
		if (word1.charAt(word1.length()-1) == word2.charAt(0))
		{
			return true;
		}
		return false;
	}
	
	public static int chkZiDianXu(String w1, String w2){
		for (int i = 0; i < w1.length(); i++)
		{
			if (w1.charAt(i) < w2.charAt(i))
			{
				return -1;
			} else {
				return 1;
			}
		}
		return 0;
	}

}
