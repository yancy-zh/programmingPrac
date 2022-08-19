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
	 * ����ָ�������������ַ������д���
	 * 
	 * ��ϸ������
	 * 
	 * ������������ַ����ϲ���
	 * 
	 * �Ժϲ�����ַ�����������Ҫ��Ϊ���±�Ϊ�������ַ����±�Ϊż�����ַ��ֱ��С��������������±���˼���ַ����ַ����е�λ�á�
	 * 
	 * ���������ַ������в���������ַ�Ϊ��0��������9�����ߡ�A��������F�����ߡ�a��������f������������������16���Ƶ�������BIT����Ĳ�������ת��Ϊ��Ӧ�Ĵ�д�ַ������ַ�Ϊ��4����Ϊ0100b����ת��Ϊ0010b��Ҳ����2��ת������ַ�Ϊ��2����
	 * ���ַ�Ϊ��7����Ϊ0111b����ת��Ϊ1110b��Ҳ����e��ת������ַ�Ϊ��д��E����
	 * 
	 * ����������str1Ϊ"dec"��str2Ϊ"fab"���ϲ�Ϊ��decfab�����ֱ�ԡ�dca���͡�efb���������������Ϊ��abcedf����ת����Ϊ��5D37BF��
	 * 
	 * ע�Ȿ�⺬�ж�����������
	 * 
	 * ���������� ���⺬�ж����������롣ÿ���������������ַ������ÿո������
	 * 
	 * ��������� ���ת����Ľ����ÿ���������һ�С�
	 * 
	 * ʾ��1 ���룺
	 * 
	 * dec fab �����
	 * 
	 * 5D37BF �������������������������������� ��Ȩ����������ΪCSDN�������������С��������ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ��������� ԭ�����ӣ�https://blog.csdn.net/lingjinyue/article/details/119523511
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
