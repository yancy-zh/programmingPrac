package demos;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxSlidingWindow
{
	
	public static void main(String[] args)
	{
		/*
		 * 有一个N个整数的数组，和一个长度为M的窗口，窗口从数组内的第一个数开始滑动直到窗口不能滑动为止， 每次窗口滑动产生一个窗口和（窗口内所有数的和），求窗口滑动产生的所有窗口和的最大值。
		 * 
		 * 输入描述： 第一行输入一个正整数N，表示整数个数。（0<N<100000） 第二行输入N个整数，整数的取值范围为[-100,100]。 第三行输入一个正整数M，M代表窗口的大小，M<=100000，且M<=N。 输出描述： 窗口滑动产生所有窗口和的最大值。 示例 1
		 * 输入输出示例仅供调试，后台判题数据一般不包含示例
		 * 
		 * 输入 6 12 10 20 30 15 23 3 1 2 3 输出 68 ———————————————— 版权声明：本文为CSDN博主「小朱小朱绝不服输」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
		 * 原文链接：https://blog.csdn.net/weixin_44052055/article/details/123901424
		 */
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			int N = Integer.parseInt(scanner.nextLine()); // num of integers
			String[] numsStr = scanner.nextLine().split(" ");
			int M = Integer.parseInt(scanner.nextLine()); // size of sliding window
			int sum = 0;
			int max = 0;
			LinkedList<Integer> window = new LinkedList<>();
			for (int i = 0; i < numsStr.length; i++)
			{
				int temp = Integer.parseInt(numsStr[i]);
				window.add(i);
				sum += temp;
				if (window.getLast() >= M) // window starts to slide
				{
					int first = window.getFirst();
					window.removeFirst();
					sum -= first;
				}
				if (i - M + 1 >= 0)
				{
					max = Math.max(max, sum);
				}
			}
			System.out.println(max);
		}
	}
	
}
