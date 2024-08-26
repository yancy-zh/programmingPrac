package plusInterviewed;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HighFive
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/high-five/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * 1086. High Five Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi,
		 * calculate each student's top five average. Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the
		 * student with IDj and their top five average. Sort result by IDj in increasing order. A student's top five average is calculated by taking the sum of
		 * their top five scores and dividing it by 5 using integer division.
		 * 
		 * Example 1: Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]] Output: [[1,87],[2,88]] Explanation: The
		 * student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87. The student with ID = 2 got
		 * scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to
		 * 88. Example 2: Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]] Output: [[1,100],[7,100]]
		 * 
		 * Constraints: 1 <= items.length <= 1000 items[i].length == 2 1 <= ID_i <= 1000 0 <= score_i <= 100 For each ID_i, there will be at least five scores.
		 */
		int[][] items = { { 1, 91 }, { 1, 92 }, { 2, 93 }, { 2, 97 }, { 1, 60 }, { 2, 77 }, { 1, 65 }, { 1, 87 }, { 1, 100 }, { 2, 100 }, { 2, 76 } };
		highFive(items);
	}
	
	public static int[][] highFive(int[][] items)
	{
		// use priority queue to add values to a stack.
		int n = items.length;
		HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();// key: student_id, val: score list.
		for (int i = 0; i < n; i++)
		{
			Integer key = items[i][0];
			Integer nextScore = items[i][1];
			if (map.containsKey(key))
			{
				PriorityQueue<Integer> currStack = map.get(key);
				// keep only top 5 scores.
				if (currStack.size() < 5)
				{
					currStack.offer(nextScore);
				}
				else
				{
					if (currStack.peek() < nextScore)
					{
						currStack.poll();
						currStack.offer(nextScore);
					}
				}
				map.put(key, currStack);
			}
			else
			{
				PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>()
				{
					public int compare(Integer num1, Integer num2)
					{
						return num1 - num2;
					}
				});
				queue.offer(nextScore);
				map.put(key, queue);
			}
		}
		int m = map.size();
		int[][] out = new int[m][2];
		int j = 0;
		for (int id : map.keySet())
		{
			out[j][0] = id;
			out[j][1] = getAvg(map.get(id));
			j++;
		}
		return out;
	}
	
	public static int getAvg(PriorityQueue<Integer> q)
	{
		int sum = 0;
		for (Integer num : q)
		{
			sum += num;
		}
		return (int) sum / q.size();
	}
}
