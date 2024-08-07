package hsbcMock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import utils.MyPrinter;

public class MissingCaches
{
	
	public static void main(String[] args)
	{
		// coding test problem 2
		int[] arr = { 0, 1, 2, 3, 0, 1, 2, 3, 4, 0, 0, 1, 2, 3 };
		System.out.println(missingCaches(4, arr));
	}
	
	public static int missingCaches(int limit, int[] arr)
	{
		int missingNumsCnt = 0;
		int n = arr.length;
		Set<Integer> set = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++)
		{
			int x = arr[i];
			if (set.contains(x))
			{
				continue;
			}
			else
			{
				missingNumsCnt++;
				if (queue.size() < limit)
				{
					queue.offer(x);
					set.add(x);
				}
				else // queue size == limit
				{
					int h = queue.poll();
					queue.add(x);
					set.remove(h);
					set.add(x);
				}
			}
			System.out.println("set: ");
			MyPrinter.printSet(set);
			System.out.println("queue: ");
			MyPrinter.printLinkedList(queue);
			System.out.println("end loop for i = %d".formatted(i));
		}
		return missingNumsCnt;
	}
}
