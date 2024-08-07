package plusInterviewed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarity
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/sentence-similarity/description/?envType=study-plan-v2&envId=premium-algo-100
		String[] sentence1 = { "great", "acting", "skills" };
		String[] sentence2 = { "fine", "drama", "talent" };
		List<List<String>> similarPairs = new ArrayList<>();
		similarPairs.add(Arrays.asList("great", "fine"));
		similarPairs.add(Arrays.asList("drama", "acting"));
		similarPairs.add(Arrays.asList("skills", "talent"));
		System.out.println(areSentencesSimilar(sentence1, sentence2, similarPairs));
	}
	
	public static boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs)
	{
		int m = sentence1.length;
		int n = sentence2.length;
		int q = similarPairs.size();
		if (m != n)
		{
			return false;
		}
		else if (m == 1 && sentence1[0].equals(sentence2[0]))
		{ return true; }
		Map<String, String> table = new HashMap<>();
		for (int i = 0; i < q; i++)
		{
			table.put(similarPairs.get(i).get(0), similarPairs.get(i).get(1));
		}
		for (int j = 0; j < m; j++)
		{
			if (table.get(sentence1[j]) != (sentence2[j]) && table.get(sentence2[j]) != (sentence1[j]) && sentence1[j] != sentence2[j])
			{ return false; }
		}
		return true;
	}
}
