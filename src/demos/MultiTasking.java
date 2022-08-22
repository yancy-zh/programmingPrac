package demos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MultiTasking
{
	// 多任务处理器。参考链接：https://blog.csdn.net/TESE_yan/article/details/115309034
	// 输入: 有m个并行处理器，
	/*
	 * 题目描述： 某多处理器多道批处理系统一次允许将所有作业调入内存，且能并行执行，其并行数等于处理机个数。该系统采用SJF的调度方式（最短作业优先，系统在调度时，总是优先调度执行处理时间最短的作业）。
	 * 
	 * 现给定处理器个数m，作业数n，每个作业的处理时间分别为t1，t2 ... tn。
	 * 
	 * 当 n > m时，首先处理时间短的 m 个作业进入处理器处理，其他的进入等待，当某个作业处理完成时，依次从等待队列中取出处理时间最短的作业进入处理。
	 * 
	 * 求系统处理完所有作业的耗时为多少？
	 * 
	 * 注：不考虑作业切换的消耗。
	 * 
	 * 输入描述： 输入2行，第一行为2个整数（采用空格分隔），分别表示处理器个数m和作业数n；第二行输入n个整数（采用空格分隔），表示每个作业的处理时长t1，t2...tn。
	 * 
	 * 0<m，n<100，0<t1，t2...tn<100。
	 * 
	 * 输出描述： 输出处理总时长
	 * 
	 * 示例1：
	 * 
	 * 输入
	 * 
	 * 3 5
	 * 
	 * 8 4 3 1 10
	 * 
	 * 输出
	 * 
	 * 13
	 * 
	 * 示例2：
	 * 
	 * 输入
	 * 
	 * 4 14 1 3 4 8 10 13 30 31 21 23 25 27 16 19
	 * 
	 * 输出
	 * 
	 * 13 ———————————————— 版权声明：本文为CSDN博主「神山极客」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/TESE_yan/article/details/115309034
	 * 调用：
	 * 
	 */
	public static void solv()
	{
		Scanner sc = new Scanner(System.in);
		int m, n;
		String[] taskTimeCosts;
		while (sc.hasNext())
		{
			String firstLineString = sc.nextLine();
			String[] strings = firstLineString.split(" ", 2);
			m = Integer.parseInt(strings[0]);
			n = Integer.parseInt(strings[1]);
			String secondLine = sc.nextLine();
			taskTimeCosts = secondLine.split(" ", -1);
			List<Integer> timeVals = new ArrayList<>();
			for (String string : taskTimeCosts)
			{
				timeVals.add(Integer.parseInt(string));
			}
			multiTaskingProcessing(m, n, timeVals);
		}
	}
	
	public static void multiTaskingProcessing(int m, int n, List<Integer> timePerTask)
	{
		timePerTask.sort(Comparator.naturalOrder());
		int rows = (n % m) == 0 ? (n / m) : (n / m + 1); // 获取任务行数
		int remainder = (n % m) == 0 ? m - 1 : (n % m) - 1; // 获取最后执行完任务的一列
		int max_time = 0;
		for (int i = 0; i < rows; ++i)
		{
			max_time += timePerTask.get(i * m + remainder);
		}
		System.out.println(max_time);
	}
	
}
