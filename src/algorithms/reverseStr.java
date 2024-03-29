package algorithms;

import java.util.Scanner;
import java.util.Stack;

public class reverseStr
{
	public static void main(String[] args)
	{
		/*
		 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
		 * 
		 * 输入描述： 输入一行，为一个只包含小写字母的字符串。
		 * 
		 * 输出描述： 输出该字符串反转后的字符串。
		 * 
		 * 示例1 输入： abcd 复制 输出： dcba
		 */
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.length(); i++)
		{
			Character ch = str.charAt(i);
			st.push(ch);
		}
		StringBuilder outStr = new StringBuilder();
		while (!st.empty())
		{
			outStr.append(st.pop());
		}
		System.out.println(outStr.toString());
	}
}