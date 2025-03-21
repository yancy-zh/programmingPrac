package algorithms;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class NthUglyNumber
{
	public int nthUglyNumber(int n)
	{
		int[] factors = { 2, 3, 5 };
		Set<Long> set = new HashSet<Long>();
		PriorityQueue<Long> heap = new PriorityQueue<>();
		set.add(1L);
		int ugly = 0;
		for (int i = 0; i < n; i++)
		{
			long curr = heap.poll();
			ugly = (int) curr;
			for (int factor : factors)
			{
				long next = curr * factor;
				if (set.add(next))
				{
					heap.offer(next);
				}
			}
		}
		return ugly;
		
	}
}
