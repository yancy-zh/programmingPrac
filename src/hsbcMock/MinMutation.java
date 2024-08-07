package hsbcMock;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinMutation
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/minimum-genetic-mutation/
		String startGene = "AACCGGTT";
		String endGene = "AACCGGTA";
		String[] bank = { "AACCGGTA" };
		System.out.println(minMutation(startGene, endGene, bank));
		String startGene1 = "AACCGGTT";
		String endGene1 = "AAACGGTA";
		String[] bank1 = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
		System.out.println(minMutation(startGene1, endGene1, bank1));
		String startGene2 = "AAAAACCC";
		String endGene2 = "AACCCCCC";
		String[] bank2 = { "AAAACCCC", "AAACCCCC", "AACCCCCC" };
		System.out.println(minMutation(startGene2, endGene2, bank2));
		String startGene3 = "AAAACCCC";
		String endGene3 = "CCCCCCCC";
		String[] bank3 = { "AAAACCCA", "AAACCCCA", "AACCCCCA", "AACCCCCC", "ACCCCCCC", "CCCCCCCC", "AAACCCCC", "AACCCCCC" };
		System.out.println(minMutation(startGene2, endGene2, bank2));
	}
	
	public static int minMutation(String startGene, String endGene, String[] bank)
	{
		int minSteps = 1; // assume it takes at least one step
		Set<String> bankSet = new HashSet<>();
		Set<String> visited = new HashSet<>();
		for (String validGene : bank)
		{
			bankSet.add(validGene);
		}
		char[] keys = { 'A', 'C', 'G', 'T' };
		if (startGene.equals(endGene))
		{ return 0; }
		if (!bankSet.contains(endGene))
		{ return -1; }
		Queue<String> queue = new ArrayDeque<>();
		queue.offer(startGene);
		visited.add(startGene);
		while (!queue.isEmpty())
		{
			for (int i = 0; i < queue.size(); i++)
			{// loop in the queue, bfs
				String curr = queue.poll();
				
				for (int j = 0; j < 8; j++)
				{// loop in the curr str chars, every string comi has 8 letters
					for (int k = 0; k < 4; k++)
					{ // loop in 4 keys, note that we are at jth char in the curr str comi
						if (keys[k] != curr.charAt(j))
						{
							StringBuilder sb = new StringBuilder(curr);
							sb.setCharAt(j, keys[k]);
							String nextGene = sb.toString();
							if (!visited.contains(nextGene) && bankSet.contains(nextGene))
							{// 变换后的序列 一定要在字符串数组 bank 中则认为该基因合法,如果该基因序列已经遍历过，则此时直接跳过
								if (nextGene.equals(endGene))
								{// 已经能实现目标变化
									return minSteps;
								}
								queue.offer(nextGene);
								visited.add(nextGene);
							}
						}
					}
				}
			}
			minSteps++;// bfs has reversed all elements.
		}
		return -1;
	}
	
}
