package algorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountingGame
{
	/*
	 * 一个有N个选手参加比赛，选手编号为1~N（3<=N<=100），有M（3<=M<=10）个评委对选手进行打分。打分规则为每个评委对选手打分，最高分10分，最低分1分。
请计算得分最多的3位选手的编号。如果得分相同，则得分高分值最多的选手排名靠前(10分数量相同，则比较9分的数量，以此类推，用例中不会出现多个选手得分完全相同的情况)。
输入描述:
第一行为半角逗号分割的两个正整数，第一个数字表示M（3<=M<=10）个评委，第二个数字表示N（3<=N<=100）个选手。
第2到M+1行是半角逗号分割的整数序列，表示评委为每个选手的打分，0号下标数字表示1号选手分数，1号下标数字表示2号选手分数，依次类推。
输出描述:
选手前3名的编号。
注：若输入为异常，输出-1，如M、N、打分不在范围内。
示例1：
输入
4,5
10,6,9,7,6
9,10,6,7,5
8,10,6,5,10
9,10,8,4,9
输出
2,1,5
说明
第一行代表有4个评委，5个选手参加比赛
矩阵代表是4*5，每个数字是选手的编号，每一行代表一个评委对选手的打分排序，
2号选手得分36分排第1，1号选手36分排第2，5号选手30分(2号10分值有3个，1号10分值只有1个，所以2号排第一)
————————————————
版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/csfun1/article/details/124362254
	 */
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int TOTAL = 100;
		LinkedList<Integer> persons = new LinkedList<>();
		persons.addFirst(0);
		//initialize
		for (int i=1; i< TOTAL; i++)
		{
			persons.addLast(i);
		}
// del one val
		int counter =0;
		for (Iterator iterator = persons.iterator(); iterator.hasNext();)
		{
			counter++;
			if (counter == M)// delete the mth elem
			{
				iterator.next();
				iterator.remove();
				counter = 0;
			}
			if (persons.size()<=M)
			{
				break;
			}
		}
			
		persons.stream().forEach(System.out::println);
		
//		//形成圈
//		persons.getLast();

	}
	
}
