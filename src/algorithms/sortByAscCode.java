package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class sortByAscCode
{
	/*
	 * ��Ŀ������ ����һ���� n ����Сд��ĸ��ɵ��ַ��������� Ascii ��ֵ��С�����������򣬲����ַ����е� k ����С ascii ��ֵ����ĸ��k >= 1�����������ĸ�����ַ�����λ������(�ַ����ĵ�һ���ַ�λ������Ϊ 0���� k ��������ַ������ȣ��������� ascii
	 * ֵ����ĸ�����ַ�����λ��������������ظ�����ĸ���������ĸ����Сλ�������� ���������� ��һ������һ���ɴ�Сд��ĸ��ɵ��ַ��� �ڶ������� k��k ������� 0��k ���Դ��������ַ����ĳ��� ��������� ����ַ����е� k ����С ascii ��ֵ����ĸ�����ַ�����λ��������k
	 * ��������ַ������ȣ��������� ascii ֵ����ĸ�� ���ַ�����λ������������� k ����С ascii �� ֵ����ĸ�����ظ������������ĸ����Сλ�������� ʾ�� 1�� ���� AbCdeFG 3 ��� 5 ��������������������������������
	 * ��Ȩ����������ΪCSDN������Mwwwwwwww����ԭ�����£���ѭCC 4.0 BY-SA��ȨЭ�飬ת���븽��ԭ�ĳ������Ӽ��������� ԭ�����ӣ�https://blog.csdn.net/Mwwwwwwww/article/details/120817325
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
