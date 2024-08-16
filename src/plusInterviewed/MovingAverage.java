package plusInterviewed;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage
{
	Queue<Integer> queue;
	int size;
	int sum;
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/moving-average-from-data-stream/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window. Implement the MovingAverage class:
		 * MovingAverage(int size) Initializes the object with the size of the window size. double next(int val) Returns the moving average of the last size
		 * values of the stream.
		 * 
		 * Example 1: Input ["MovingAverage", "next", "next", "next", "next"] [[3], [1], [10], [3], [5]] Output [null, 1.0, 5.5, 4.66667, 6.0] Explanation
		 * MovingAverage movingAverage = new MovingAverage(3); movingAverage.next(1); // return 1.0 = 1 / 1 movingAverage.next(10); // return 5.5 = (1 + 10) / 2
		 * movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3 movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
		 * 
		 * Constraints: 1 <= size <= 1000 -10^5 <= val <= 10^5 At most 10^4 calls will be made to next.
		 * 
		 */
		MovingAverage obj = new MovingAverage(3);
		System.out.println(obj.next(1));
		System.out.println(obj.next(10));
		System.out.println(obj.next(3));
		System.out.println(obj.next(5));
	}
	
	public MovingAverage(int size)
	{
		queue = new ArrayDeque<Integer>();
		this.size = size;
	}
	
	public double next(int val)
	{
		if (queue.size() < this.size)
		{
			queue.offer(val);
			this.sum += val;
			return (double) this.sum / queue.size();
		}
		else if (queue.size() == this.size)
		{
			int rmVal = queue.poll();
			this.sum -= rmVal;
			queue.offer(val);
			this.sum += val;
			return (double) this.sum / this.size;
		}
		return -1.0;
	}
}
