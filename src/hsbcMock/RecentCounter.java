package hsbcMock;

import java.util.ArrayDeque;
import java.util.Queue;

public class RecentCounter
{
	Queue<Integer> q;
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/number-of-recent-calls/description/?envType=problem-list-v2&envId=xvuz7ici
		RecentCounter recentCounter = new RecentCounter();
		recentCounter.ping(1);
		recentCounter.ping(100);
		recentCounter.ping(3001);
		System.out.println(recentCounter.ping(3002));
	}
	
	public RecentCounter()
	{
		q = new ArrayDeque<Integer>();
	}
	
	public int ping(int t)
	{
		q.offer(t);
		while (q.peek() < t - 3000)
		{
			q.poll();
		}
		return q.size();
	}
	
}
