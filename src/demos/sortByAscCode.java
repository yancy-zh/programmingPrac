package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class sortByAscCode
{
	/*
	 * 题目描述： 输入一个由 n 个大小写字母组成的字符串，按照 Ascii 码值从小到大的排序规则，查找字符串中第 k 个最小 ascii 码值的字母（k >= 1），输出该字母所在字符串的位置索引(字符串的第一个字符位置索引为 0）。 k 如果大于字符串长度，则输出最大 ascii
	 * 值的字母所在字符串的位置索引，如果有重复的字母，则输出字母的最小位置索引。 输入描述： 第一行输入一个由大小写字母组成的字符串 第二行输入 k，k 必须大于 0，k 可以大于输入字符串的长度 输出描述： 输出字符串中第 k 个最小 ascii 码值的字母所在字符串的位置索引。k
	 * 如果大于字符串长度，则输出最大 ascii 值的字母所 在字符串的位置索引，如果第 k 个最小 ascii 码 值的字母存在重复，则输出该字母的最小位置索引。 示例 1： 输入 AbCdeFG 3 输出 5 ————————————————
	 * 版权声明：本文为CSDN博主「Mwwwwwwww」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/Mwwwwwwww/article/details/120817325
	 */
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext())
		{
			String inStr = scanner.nextLine();
			int k = Integer.parseInt(scanner.nextLine()); // the index of the query element
			int[] chars = inStr.chars().toArray();
			Arrays.sort(chars);
			int val;
			if (k > inStr.length()) // if k is larger than the inStr length, print the char with largest val
			{
				val = chars[chars.length - 1];
			}
			else
			{
				val = chars[k-1];
			}
			
			for (int i = 0; i < inStr.length(); i++)
			{
				if (inStr.charAt(i) == val)
				{
					System.out.println(i);
					break; // ignore repetitive
				}
			}
		}
	}
	
}
