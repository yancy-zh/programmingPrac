package algorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class BestTimeRanges
{
	/*
	 * 查找接口成功率最优时间段】
服务之间交换的接口成功率作为服务调用关键质量特性，某个时间段内的接口失败率使用一个数组表示，数组中每个元素都是单位时间内失败率数值，数组中的数值为0~100的整数，给定一个数值(minAverageLost)表示某个时间段内平均失败率容忍值，即平均失败率小于等于minAverageLost，找出数组中最长时间段，如果未找到则直接返回NULL。
输入描述:
输入有两行内容，第一行为{minAverageLost}，第二行为{数组}，数组元素通过空格(" “)分隔，minAverageLost及数组中元素取值范围为0~100的整数，数组元素的个数不会超过100个。
输出描述:
找出平均值小于等于minAverageLost的最长时间段，输出数组下标对，格式{beginIndex}-{endIndx}(下标从0开始)，如果同时存在多个最长时间段，则输出多个下标对且下标对之间使用空格(” ")拼接，多个下标对按下标从小到大排序。
示例1：
输入
1
0 1 2 3 4
输出
0-2
说明
A、输入解释：minAverageLost=1，数组[0, 1, 2, 3, 4]
B、前3个元素的平均值为1，因此数组第一个至第三个数组下标，即0-2
————————————————
版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/csfun1/article/details/124362254
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int minAverageLost = Integer.parseInt(scanner.nextLine());
		List<Integer> rates = Arrays.asList(scanner.nextLine().split(" ")).stream().map(o->Integer.parseInt(o)).collect(Collectors.toList());
		int left = 0;
		int right = 0;
		StringBuilder sBuilder = new StringBuilder();
		while (right < rates.size()) {
			if (right == left)
			{
				right++;
			}
			if ( chkAvgMean(rates, left, right, minAverageLost))// expand the right pointer
			{
				while(right < rates.size() && chkAvgMean(rates, left, right, minAverageLost)) {
					right++;
				}
				right--;
				sBuilder.append(left).append("-").append(right-1).append(" ");
				right++;
			} else {
				left++;
			}
			
		}
		System.out.println(sBuilder);
	}
	
	public static boolean chkAvgMean(List<Integer> rates,int left, int right, int avg)
	{
		double total = 0;
		for (int i = left; i < right; i++)
		{
			total += rates.get(i);
		}
		return (double)(total/(right-left+1)) <= avg;
	}
}
