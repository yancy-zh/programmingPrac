package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StringMerge
{
	/*
	 * 按照指定规则对输入的字符串进行处理。
	 * 
	 * 详细描述：
	 * 
	 * 将输入的两个字符串合并。
	 * 
	 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
	 * 
	 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’；
	 * 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
	 * 
	 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
	 * 
	 * 注意本题含有多组样例输入
	 * 
	 * 输入描述： 本题含有多组样例输入。每组样例输入两个字符串，用空格隔开。
	 * 
	 * 输出描述： 输出转化后的结果。每组样例输出一行。
	 * 
	 * 示例1 输入：
	 * 
	 * dec fab 输出：
	 * 
	 * 5D37BF ———————————————— 版权声明：本文为CSDN博主「不服输的小悦阳」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/lingjinyue/article/details/119523511
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split(" ");
		// merge two parts
		String merged = parts[0].concat(parts[1]);
		//TODO: use linkedList
		List<Character> oddDigits = new ArrayList<>();
		List<Character> evenDigits = new ArrayList<>();
		for (int i = 0; i < merged.length(); i++)
		{
			if (i % 2 == 0)// odd digits
			{
				oddDigits.add(merged.charAt(i));
			}
			else
			{
				evenDigits.add(merged.charAt(i));
			}
		}
		evenDigits.sort(null);
		oddDigits.sort(null);
		StringBuilder sortedMerged = new StringBuilder();
		for (int i = 0; i < merged.length(); i++)
		{
			if (i % 2 == 0)// odd digits
			{
				sortedMerged.append(oddDigits.get(i/2));
			}
			else
			{
				sortedMerged.append(evenDigits.get(i/2+1));
			}
		}
		System.out.println(sortedMerged.toString()); 
//		oddDigits.forEach(System.out::println);
	}
	
}
