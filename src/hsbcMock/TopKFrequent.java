package hsbcMock;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import utils.MyPrinter;

public class TopKFrequent
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/top-k-frequent-elements/description/
		int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		MyPrinter.printPrimitiveInt(topKFrequent(nums, k));
	}
	
	public static int[] topKFrequent(int[] nums, int k)
	{
		// create freq map
		HashMap<Integer, Integer> occMap = new HashMap<>();
		// count the frequency for each num in nums
		for (int i : nums)
		{
			// occMap[i][0]: num
			// occMap[i][0]: count
			occMap.put(i, occMap.getOrDefault(i, 0) + 1);
		}
		// init a priority queue and override its comparator method
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>()
		{
			public int compare(int[] a, int[] b)
			{
				return a[1] - b[1];
			}
		});
		// implement rules, interate in the occurance map:
		// 1. when the heap top has freq less than k, add the new element
		int m = 0;
		for (Map.Entry<Integer, Integer> entry : occMap.entrySet())
		{
			m = queue.size();
			int num = entry.getKey(), count = entry.getValue();
			if (m != k)
			{
				queue.offer(new int[] { num, count });
			}
			else
			{
				int topFreq = queue.peek()[1];
				if (count > topFreq)
				{
					queue.poll();
					queue.offer(new int[] { num, count });
				}
				
			}
		}
		int[] ret = new int[k];
		for (int i = 0; i < k; i++)
		{
			ret[i] = queue.poll()[0];
		}
		return ret;
	}
}
