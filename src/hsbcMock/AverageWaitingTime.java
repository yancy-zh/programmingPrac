package hsbcMock;

public class AverageWaitingTime
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/average-waiting-time/
		// int[][] customers = { { 1, 2 }, { 2, 5 }, { 4, 3 } };
		// System.out.println(averageWaitingTime(customers));
		int[][] customers1 = { { 5, 2 }, { 5, 4 }, { 10, 3 }, { 20, 1 } };
		System.out.println(averageWaitingTime(customers1));
		
	}
	
	public static double averageWaitingTime(int[][] customers)
	{
		int n = customers.length;
		// cook[i][0] is the time that the cook begins cooking the ith dish, cook[i][1] being the time that the cook finishes cooking the ith dish
		long[][] cook = new long[n][2];
		long[] wait = new long[n];
		cook[0][0] = customers[0][0]; // the time that the cook starts cooking the 1st dish is the time that the customer 1 arrives
		cook[0][1] = cook[0][0] + customers[0][1];
		long total_wait = customers[0][1];
		for (int i = 1; i < n; i++)
		{
			cook[i][0] = Math.max(customers[i][0], cook[i - 1][1]);
			cook[i][1] = cook[i][0] + customers[i][1];
			wait[i] = cook[i][1] - customers[i][0];
			total_wait += wait[i];
		}
		return (double) total_wait / n;
	}
}
