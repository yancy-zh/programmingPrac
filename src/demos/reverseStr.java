package demos;

import java.util.Scanner;
import java.util.Stack;

public class reverseStr
{
	public static void main(String[] args)
	{
		/*
		 * ����һ��ֻ����Сд��ĸ���ַ�����Ȼ��������ַ�����ת����ַ��������ַ������Ȳ�����1000��
		 * 
		 * ���������� ����һ�У�Ϊһ��ֻ����Сд��ĸ���ַ�����
		 * 
		 * ��������� ������ַ�����ת����ַ�����
		 * 
		 * ʾ��1 ���룺 abcd ���� ����� dcba
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