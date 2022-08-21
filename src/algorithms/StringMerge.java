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
