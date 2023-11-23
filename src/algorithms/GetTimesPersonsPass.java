package algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GetTimesPersonsPass
{
	public static List<Integer> getTimes(List<Integer> time, List<Integer> direction)
	{
		List<Integer> outSequence = new ArrayList<>();
		Queue<Integer> enters = new LinkedList<Integer>();
		Queue<Integer> exits = new LinkedList<Integer>();
		int n = time.size();
		for (int i = 0; i < n; i++)
		{
			Queue<Integer> q = direction.get(i) == 1 ? exits : enters;
			q.offer(i);
		}
		int[] result = new int[n];
		int lastTime = -2;
		Queue<Integer> lastQueue = exits;
		while (enters.size() > 0 && exits.size() > 0)
		{
			int currTime = lastTime + 1;
			int peekEnterTime = time.get(enters.peek());
			int peekExitTime = time.get(exits.peek());
			Queue<Integer> q;
			if (currTime < peekEnterTime && currTime < peekExitTime)
			{
				q = peekEnterTime < peekExitTime ? enters : exits;
				int personIdx = q.poll();
				outSequence.set(personIdx, time.get(personIdx));
				lastTime = time.get(personIdx);
				lastQueue = q;
			}
			else
			{
				if (currTime >= peekEnterTime && currTime >= peekExitTime)
				{
					q = lastQueue;
				}
				else
				{
					q = currTime >= peekEnterTime ? enters : exits;
					
				}
				int personIdx = q.poll();
				outSequence.set(personIdx, currTime);
				lastTime = currTime;
				lastQueue = q;
			}
		}
		Queue<Integer> q = enters.size() > 0 ? enters : exits;
		while (q.size() > 0)
		{
			int currTime = lastTime + 1;
			int personIdx = q.poll();
			if (currTime < time.get(personIdx))
			{
				currTime = time.get(personIdx);
			}
			outSequence.set(personIdx, currTime);
			lastTime = currTime;
		}
		return outSequence;
	}
}
