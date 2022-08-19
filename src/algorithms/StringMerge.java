package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
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
	private static Map<Character, Integer> baseMap = new HashMap<Character, Integer>(){
		{
			put('0', 0);
			put('1', 1);
			put('2', 2);
			put('3', 3);
			put('4', 4);
			put('5', 5);
			put('6', 6);
			put('7', 7);
			put('8', 8);
			put('9', 9);
			put('A', 10);
			put('B', 11);
			put('C', 12);
			put('D', 13);
			put('E', 14);
			put('F', 15);
			put('a', 10);
			put('b', 11);
			put('c', 12);
			put('d', 13);
			put('e', 14);
			put('f', 15);
		}
	};
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split(" ");
		// merge two parts
		String merged = parts[0].concat(parts[1]);
		// TODO: use linkedList
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
		StringBuilder sb1 = new StringBuilder();
		int j = 0, k = 0;
		for (int i = 0; i < merged.length(); i++)
		{
			if (i % 2 == 0)// odd digits
			{
				sb1.append(oddDigits.get(j));
				j++;
			}
			else
			{
				sb1.append(evenDigits.get(k));
				k++;
			}
		}
		String sortedMerged = sb1.toString();
		System.out.println(sortedMerged);
		// replace the strs based on the table
		for (int i = 0; i < sortedMerged.length(); i++)
		{
			System.out.println(convertChars(sortedMerged.charAt(i)));
		}
		// oddDigits.forEach(System.out::println);
	}
	
	public static char convertChars(char ch)
	{
		char res = ch;
		if (ch > '0' && ch < '9' || ch > 'a' && ch < 'f' || ch > 'A' && ch < 'F')
		{
			String binaryStr = String.format("%4s",  Integer.toBinaryString(baseMap.get(ch))).replace(' ', '0');
			System.out.println(binaryStr);
			
		}
		return res;
	}
	
	public String revertStr(String inStr)
	{
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < inStr.length(); i++)
		{
			Character ch = inStr.charAt(i);
			st.push(ch);
		}
		StringBuilder outStr = new StringBuilder();
		while (!st.empty())
		{
			outStr.append(st.pop());
		}
		return outStr.toString();
	}
}
