package demos;

import java.util.Scanner;

public class StringDevideBy8
{
	
	public static void main(String[] args)
	{
		/*
		 * ���������ַ������밴����Ϊ8���ÿ�������ַ�������������� ���Ȳ���8���������ַ������ں��油����0�����ַ��������� ��ע�������ж������룩 ���������� ���������ַ���(������,ÿ���ַ�������С�ڵ���100)
		 * 
		 * ��������� ����������зָ��ĳ���Ϊ8�����ַ���
		 * 
		 * ʾ��1 ���룺 abc 123456789 ���� ����� abc00000 12345678 90000000
		 */
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext())
		{
			String str = sc.nextLine();
			int len = str.length();
			// check if the str len is dividable by 8
			if (len % 8 != 0)
			{
				int remainder = len % 8;
				int numZeroToPad = 8 - remainder;
				StringBuilder sb = new StringBuilder(str);
				for (int i = 0; i < numZeroToPad; i++)
				{
					sb.append('0');
				}
				str = sb.toString();
			}
			// cut the string by 8
			int numSection = str.length() / 8;
			for (int i = 0; i < numSection; i++)
			{
				System.out.println(str.substring(i * 8, i * 8 + 8));
			}
		}
		
	}
	public static String[] stringDivideBy8(String str)
	{
		int len = str.length();
		// check if the str len is dividable by 8
		if (len % 8 != 0)
		{
			int remainder = len % 8;
			int numZeroToPad = 8 - remainder;
			StringBuilder sb = new StringBuilder(str);
			for (int i = 0; i < numZeroToPad; i++)
			{
				sb.insert(i, "0");
			}
			str = sb.toString();
		}
		// cut the string by 8
		int numSection = str.length() / 8;
		String[] strArr = new String[numSection];
		for (int i = 0; i < numSection; i++)
		{
			strArr[i] = (str.substring(i * 8, i * 8 + 8));
		}
		return strArr;
	}
}
